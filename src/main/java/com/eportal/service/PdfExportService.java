package com.eportal.service;


import net.sf.jasperreports.engine.JRException;


public interface PdfExportService {
    byte[] freemarkerToByteArray() throws Exception;

    byte[] jrxmlToByteArray() throws JRException;
}
