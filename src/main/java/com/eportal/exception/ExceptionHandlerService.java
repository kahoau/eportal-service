package com.eportal.exception;


import com.fasterxml.jackson.databind.JsonMappingException;

public interface ExceptionHandlerService {
    ApiExceptionInfo handleException(GeneralApiException ge);

    ApiExceptionInfo handleException(JsonMappingException ge);

    ApiExceptionInfo handleException(Throwable e);
}
