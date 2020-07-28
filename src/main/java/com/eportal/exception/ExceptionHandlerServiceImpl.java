package com.eportal.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
public class ExceptionHandlerServiceImpl implements ExceptionHandlerService {
    @Override
    public ApiExceptionInfo handleException(GeneralApiException ge) {
        log.warn(ge.getMessage(), ge);
        return ApiExceptionInfo.builder()
                .timestamp(now())
                .status(ge.getStatus())
                .message(ge.getMessage())
                .build();
    }

    @Override
    public ApiExceptionInfo handleException(JsonMappingException ge) {
        log.warn(ge.getMessage(), ge);
        return ApiExceptionInfo.builder()
                .timestamp(now())
                .status(BAD_REQUEST)
                .message(ge.getMessage())
                .build();
    }

    @Override
    public ApiExceptionInfo handleException(Throwable e) {
        log.error("Unexpected error", e);

        return ApiExceptionInfo.builder()
                .timestamp(now())
                .status(INTERNAL_SERVER_ERROR)
                .message("Could not process request: " + e.getMessage())
                .build();
    }
}
