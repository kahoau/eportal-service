package com.eportal;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * test program to publish file to mqtt topic
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EportalTest {
    @Test
    public void generatePdfJasper() throws JRException {
        log.info("hello");

        String baseDir = "/Users/kahoau/Desktop/dev/projects/cncbi-projects/eportal-service/src/main/resources/";
        JasperReport jasperReport = JasperCompileManager.compileReport(baseDir + "eForm_A4.jrxml");
        JRDataSource jrDataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, baseDir + "eForm_A4.pdf");
    }
}