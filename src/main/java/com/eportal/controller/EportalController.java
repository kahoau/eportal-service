package com.eportal.controller;


import com.eportal.model.PDFDataTest;
import com.eportal.service.EportalService;
import com.eportal.util.PDFTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class EportalController {
    @Autowired
    private EportalService eportalService;

    @RequestMapping("/pdf/export")
    public void exportPdf(HttpServletResponse response) throws Exception{
        ByteArrayOutputStream baos = null;
        OutputStream out = null;
        try {
			// The data in the template, the actual application from the database query
            Map<String,Object> data = new HashMap<>();
            data.put("curr", 1);
            data.put("one", 2);
            data.put("two", 1);
            data.put("three", 6);

            List<PDFDataTest> detailList = new ArrayList<>();
            detailList.add(new PDFDataTest(123456,"test","test","test","test"));
            detailList.add(new PDFDataTest(111111,"test","test","test","test"));
            detailList.add(new PDFDataTest(222222,"test","test","test","test"));
            data.put("detailList", detailList);

            baos = PDFTemplateUtil.createPDF(data, "dashboard.ftl");;
			// Set the response message header to tell the browser that the current response is a download file
            response.setContentType( "application/x-msdownload");
            // Tell the browser that the current response data requires user intervention to save to the file, and what the file name is. If the file name has Chinese, it must be URL encoded.
            String fileName = URLEncoder.encode("Monthly report.pdf", "UTF-8");
            response.setHeader( "Content-Disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            baos.writeTo(out);
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Export failed:" + e.getMessage());
        } finally{
            if(baos != null){
                baos.close();
            }
            if(out != null){
                out.close();
            }
        }
    }
}
