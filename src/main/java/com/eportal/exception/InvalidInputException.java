package com.eportal.exception;

import org.springframework.http.HttpStatus;

public class InvalidInputException extends GeneralApiException {
    public InvalidInputException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
