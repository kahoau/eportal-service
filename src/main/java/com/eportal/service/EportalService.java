package com.eportal.service;


import net.sf.jasperreports.engine.JRException;

import java.io.OutputStream;

public interface EportalService {
    void exportPdfJasper() throws JRException;

    void exportPdfFreemarker() throws Exception;

    OutputStream freemarkerToOutputStream() throws Exception;
}
