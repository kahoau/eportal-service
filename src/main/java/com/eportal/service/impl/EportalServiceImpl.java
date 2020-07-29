package com.eportal.service.impl;


import com.eportal.model.PDFDataTest;
import com.eportal.service.EportalService;
import com.eportal.util.PDFTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class EportalServiceImpl implements EportalService {
    String baseDir = "/Users/kahoau/Desktop/dev/projects/cncbi-projects/eportal-service/src/main/resources/";

    public void exportPdfJasper() throws JRException {
        JasperReport jasperReport = JasperCompileManager.compileReport(baseDir + "eForm_A4.jrxml");
        JRDataSource jrDataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, baseDir + "eForm_A4.pdf");
    }

    public void exportPdfFreemarker() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) freemarkerToOutputStream();

        try(OutputStream outputStream = new FileOutputStream(baseDir + "thefilename.pdf")) {
            byteArrayOutputStream.writeTo(outputStream);
        }
    }

    public OutputStream freemarkerToOutputStream() throws Exception {
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

        return PDFTemplateUtil.createPDF(data, "pdf-template.ftl");
    }
}
