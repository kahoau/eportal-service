package com.eportal.controller;

import com.eportal.service.EportalService;
import com.eportal.util.PDFTemplateUtil;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class EportalController {
    @Autowired
    private EportalService eportalService;

    @RequestMapping("/pdf/export/{templateType}")
    public void pdfExport(@PathVariable String templateType, HttpServletResponse response) throws Exception {
        byte[] byteArr = "freemarker".equals(templateType) ? eportalService.freemarkerToByteArray() :
                         "jasper".equals(templateType) ? eportalService.jrxmlToByteArray() :
                         new byte[0];
        if (!ArrayUtils.isEmpty(byteArr)) {
            PDFTemplateUtil.writeToResponse(response, "eform_" + templateType + ".pdf", byteArr);
        }
    }
}
