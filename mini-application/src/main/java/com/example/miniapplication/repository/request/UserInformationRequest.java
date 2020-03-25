package com.example.miniapplication.repository.request;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UserInformationRequest {
    @NonNull
    private String userName;

    @NonNull
    private String password;

    public static UserInformationRequest of(String userName, String password) {
        return UserInformationRequest.builder()
                .userName(userName)
                .password(password)
                .build();
    }
}
