package com.example.miniapplication.service;

import com.example.miniapplication.repository.UserRepository;
import com.example.miniapplication.repository.request.PostingRequestForDb;
import com.example.miniapplication.repository.response.PostResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PostingService {
    private final UserRepository userRepository;

    @Transactional
    public List<PostResponse> getPostingHistory(@NonNull int userId) {
        try {
            return userRepository.getPostingHistory(userId);
        } catch (Exception e) {
            log.error("投稿履歴取得に失敗" + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Transactional
    public List<PostResponse> getOtherLatestHistory(@NonNull int userId) {
        try {
            return userRepository.getOtherLatestHistory(userId);
        } catch (Exception e) {
            log.error("他人の投稿履歴取得に失敗" + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Transactional
    public boolean posting(@NonNull int userId, @NonNull String postingMessage) {
        try {
            userRepository.posting(new PostingRequestForDb(userId, postingMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
