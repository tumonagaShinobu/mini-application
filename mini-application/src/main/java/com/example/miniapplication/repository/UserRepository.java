package com.example.miniapplication.repository;

import com.example.miniapplication.repository.request.FollowingInformation;
import com.example.miniapplication.repository.request.PostingRequestForDb;
import com.example.miniapplication.repository.request.UserInformationRequest;
import com.example.miniapplication.repository.response.PostResponse;
import com.example.miniapplication.repository.response.UserInformationResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    void registUser(UserInformationRequest request);

    UserInformationResponse fetchByUserName(String userName);

    int isUniqueUserName(String userName);

    void insertFollowing(FollowingInformation followingInformation);

    int isFollowing(FollowingInformation followingInformation);

    List<PostResponse> getPostingHistory(int userId);

    List<PostResponse> getOtherLatestHistory(int userId);

    void posting(PostingRequestForDb request);
}
