package com.eportal.controller;


import com.eportal.service.EportalService;
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

    @RequestMapping("/pdf/export")
    public void exportPdf(HttpServletResponse response) throws Exception {
        try (ByteArrayOutputStream baos = (ByteArrayOutputStream) eportalService.freemarkerToOutputStream()) {
            // Set the response message header to tell the browser that the current response is a download file
            response.setContentType( "application/x-msdownload");
            // Tell the browser that the current response data requires user intervention to save to the file, and what the file name is. If the file name has Chinese, it must be URL encoded.
            String fileName = URLEncoder.encode("Monthly report.pdf", "UTF-8");
            response.setHeader( "Content-Disposition", "attachment;filename=" + fileName);
            OutputStream out = response.getOutputStream();
            baos.writeTo(out);
        }
    }
}
