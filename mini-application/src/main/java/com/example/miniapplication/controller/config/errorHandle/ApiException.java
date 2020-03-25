package com.example.miniapplication.controller.config.errorHandle;

public class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
}
