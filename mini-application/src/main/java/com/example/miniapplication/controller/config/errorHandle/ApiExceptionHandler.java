package com.example.miniapplication.controller.config.errorHandle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(ApiException exception) {
        log.error("handleException", exception);

        return new ErrorResponse(exception.getMessage());
    }
}
