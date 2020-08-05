package com.eportal.config;

import com.eportal.exception.ExceptionHandlerService;
import com.eportal.exception.ExceptionHandlerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionHandlerConfig {
    @Bean
    public ExceptionHandlerService exceptionHandlerService() {
        return new ExceptionHandlerServiceImpl();
    }
}
