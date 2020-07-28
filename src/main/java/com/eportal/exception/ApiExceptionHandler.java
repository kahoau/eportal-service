package com.eportal.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {
    private final ExceptionHandlerService es;

    @ExceptionHandler(JsonMappingException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ApiExceptionInfo handleInvalidFormatException(JsonMappingException e) {
        return es.handleException(e);
    }


    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ApiExceptionInfo handleInvalidInputException(InvalidInputException e) {
        return es.handleException(e);
    }
}
