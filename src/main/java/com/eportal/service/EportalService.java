package com.eportal.service;


import net.sf.jasperreports.engine.JRException;


public interface EportalService {
    byte[] freemarkerToByteArray() throws Exception;

    byte[] jrxmlToByteArray() throws JRException;
}
