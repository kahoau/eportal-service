package com.eportal.service.impl;


import com.eportal.model.PDFDataTest;
import com.eportal.service.EportalService;
import com.eportal.util.PDFTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class EportalServiceImpl implements EportalService {
    public byte[] jrxmlToByteArray() throws JRException {
        // Fetching the .jrxml file from the resources folder.
        final InputStream inputStream = this.getClass().getResourceAsStream("/eForm_A4.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JRDataSource jrDataSource = new JREmptyDataSource();

        JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport, null, jrDataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public byte[] freemarkerToByteArray() throws Exception {
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

        ByteArrayOutputStream baos = (ByteArrayOutputStream) PDFTemplateUtil.createPDF(data, "pdf-template.ftl");
        return baos.toByteArray();
    }
}
