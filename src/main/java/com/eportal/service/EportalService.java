package com.eportal.service;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.IOException;
import java.io.OutputStream;

public interface EportalService {
    JasperPrint toJasperPrint() throws JRException, IOException;

    void exportPdfJasper() throws JRException, IOException;

    void exportPdfFreemarker() throws Exception;

    OutputStream freemarkerToOutputStream() throws Exception;
}
