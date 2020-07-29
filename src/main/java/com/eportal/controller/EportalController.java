package com.eportal.controller;


import com.eportal.service.EportalService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;


@RestController
public class EportalController {
    @Autowired
    private EportalService eportalService;

    @RequestMapping("/pdf/export/freemarker")
    public void pdfExportFreemarker(HttpServletResponse response) throws Exception {
        try (ByteArrayOutputStream baos = (ByteArrayOutputStream) eportalService.freemarkerToOutputStream()) {
            // Set the response message header to tell the browser that the current response is a download file
            response.setContentType( "application/x-msdownload");
            // Tell the browser that the current response data requires user intervention to save to the file, and what the file name is. If the file name has Chinese, it must be URL encoded.
            String fileName = URLEncoder.encode("eform_freemarker.pdf", "UTF-8");
            response.setHeader( "Content-Disposition", "attachment;filename=" + fileName);
            OutputStream out = response.getOutputStream();
            baos.writeTo(out);
        }
    }

    @RequestMapping("/pdf/export/jasper")
    public void pdfExportJasper(HttpServletResponse response) throws Exception {
        JasperPrint jasperPrint = eportalService.toJasperPrint();
        byte[] byteArray = JasperExportManager.exportReportToPdf(jasperPrint);

        response.setContentType( "application/x-msdownload");
        String fileName = URLEncoder.encode("eform_jasper.pdf", "UTF-8");
        response.setHeader( "Content-Disposition", "attachment;filename=" + fileName);
        response.setContentLength(byteArray.length);

        try (OutputStream os = response.getOutputStream()) {
            os.write(byteArray , 0, byteArray.length);
        }
    }
}
