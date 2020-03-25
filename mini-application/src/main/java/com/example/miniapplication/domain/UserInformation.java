package com.example.miniapplication.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserInformation {
    private String userName;
    private String password;
    private Date createdAt;
}
