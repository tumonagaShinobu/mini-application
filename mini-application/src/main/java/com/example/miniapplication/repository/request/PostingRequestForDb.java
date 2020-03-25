package com.example.miniapplication.repository.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class PostingRequestForDb {
    @NonNull
    private int userId;
    private String postingMessage;
}
