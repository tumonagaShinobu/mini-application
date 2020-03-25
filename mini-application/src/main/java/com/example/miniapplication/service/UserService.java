package com.example.miniapplication.service;

import com.example.miniapplication.controller.config.account.UserAccount;
import com.example.miniapplication.controller.request.RegisterRequest;
import com.example.miniapplication.repository.UserRepository;
import com.example.miniapplication.repository.request.UserInformationRequest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //アカウント登録
    public boolean registUser(@NonNull RegisterRequest request) {
        if (userRepository.isUniqueUserName(request.getUserName()) == 0) {
            userRepository.registUser(UserInformationRequest.of(request.getUserName(), passwordEncoder.encode(request.getPassword())));
            return true;
        } else {
            return false;
        }
    }

    //spring sessionが利用するログイン判定
    @Override
    public UserDetails loadUserByUsername(@NonNull String userName) throws UsernameNotFoundException {
        var userInformationResponse = userRepository.fetchByUserName(userName);
        if (userInformationResponse != null) {
            return new UserAccount(userInformationResponse.getUserName(), userInformationResponse.getPassword(), userInformationResponse.getUserId());
        } else {
            throw new UsernameNotFoundException("ユーザーが見つかりませんでした");
        }
    }
}
