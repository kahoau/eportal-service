package com.eportal.controller;

import com.eportal.service.PdfExportService;
import com.eportal.util.PDFTemplateUtil;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/pdf")
public class PdfExportController {
    @Autowired
    private PdfExportService pdfExportService;

    @RequestMapping("/export/{templateType}")
    public void pdfExport(@PathVariable String templateType, HttpServletResponse response) throws Exception {
        byte[] byteArr = "freemarker".equals(templateType) ? pdfExportService.freemarkerToByteArray() :
                         "jasper".equals(templateType) ? pdfExportService.jrxmlToByteArray() :
                         new byte[0];
        if (!ArrayUtils.isEmpty(byteArr)) {
            PDFTemplateUtil.writeToResponse(response, "eform_" + templateType + ".pdf", byteArr);
        }
    }
}
