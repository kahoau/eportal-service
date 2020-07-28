package com.eportal;

import com.eportal.service.EportalService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EportalTest {
    @Autowired
    private EportalService eportalService;


    @Test
    public void exportPdfJasperTest() throws JRException {
        eportalService.exportPdfJasper();
    }

    @Test
    public void exportPdfFreemarkerTest() throws Exception {
        eportalService.exportPdfFreemarker();
    }
}
