package com.example.miniapplication.repository.response;

import lombok.Data;

@Data
public class PostResponse {
    private int postId;
    private int userId;
    private String createdDate;
    private String contents;
    private String userName;
}
