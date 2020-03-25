package com.example.miniapplication.controller.Rest;

import com.example.miniapplication.controller.config.account.UserAccount;
import com.example.miniapplication.controller.config.errorHandle.ApiException;
import com.example.miniapplication.controller.request.FollowRequest;
import com.example.miniapplication.controller.response.FollowResponse;
import com.example.miniapplication.service.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private final FollowService followingService;

    @PostMapping("/follow")
    public FollowResponse followUser(@AuthenticationPrincipal UserAccount userAccount, @RequestBody FollowRequest request) throws ApiException {
        return new FollowResponse(followingService.followUser(userAccount.getUserId(), request.getFollowingId()));
    }
}
