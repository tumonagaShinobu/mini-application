package com.example.miniapplication.controller.request;

import lombok.Data;

import javax.validation.constraints.Pattern;


@Data
public class RegisterRequest {
    @Pattern(regexp = "[0-9a-zA-Z]{3,19}")
    private String userName;
    @Pattern(regexp = "[0-9a-zA-Z]{4,29}")
    private String password;
}
