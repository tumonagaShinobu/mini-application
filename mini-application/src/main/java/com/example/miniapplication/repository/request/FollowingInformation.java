package com.example.miniapplication.repository.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowingInformation {
    private int userId;
    private int followingId;
}
