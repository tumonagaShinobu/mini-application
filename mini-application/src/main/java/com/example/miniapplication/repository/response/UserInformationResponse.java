package com.example.miniapplication.repository.response;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class UserInformationResponse {
    @NonNull
    private int userId;
    @NonNull
    private String userName;
    @NonNull
    private String password;

    private Date createdAt;
}
