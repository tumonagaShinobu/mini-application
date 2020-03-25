package com.example.miniapplication.service;

import com.example.miniapplication.controller.config.errorHandle.ApiException;
import com.example.miniapplication.repository.UserRepository;
import com.example.miniapplication.repository.request.FollowingInformation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class FollowService {
    private final UserRepository userRepository;

    @Transactional
    public boolean followUser(int userId, int followId) throws ApiException {
        var followingInformation = new FollowingInformation(userId, followId);
        try {
            if (userRepository.isFollowing(followingInformation) == 0) {
                userRepository.insertFollowing(followingInformation);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new ApiException("フォローに失敗しました:" + e.getMessage());
        }
    }
}
