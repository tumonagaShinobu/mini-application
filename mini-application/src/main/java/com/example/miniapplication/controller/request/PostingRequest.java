package com.example.miniapplication.controller.request;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
public class PostingRequest {
    @NotEmpty
    @NonNull
    private String postingMessage;
}
