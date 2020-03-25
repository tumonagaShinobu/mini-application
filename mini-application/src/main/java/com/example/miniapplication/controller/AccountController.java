package com.example.miniapplication.controller;

import com.example.miniapplication.controller.config.account.UserAccount;
import com.example.miniapplication.controller.request.RegisterRequest;
import com.example.miniapplication.service.PostingService;
import com.example.miniapplication.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class AccountController {
    private final UserService userService;
    private final PostingService postingService;

    @PostMapping("account/register")
    public String register(@Validated @ModelAttribute RegisterRequest request, Model model) {
        if (userService.registUser(request)) {
            log.info("登録成功");
            model.addAttribute("isRegist", true);
            return "login";
        } else {
            log.info("登録失敗");
            model.addAttribute("isError", true);
            return "regist";
        }
    }

    @RequestMapping("/")
    public String init(@AuthenticationPrincipal UserAccount userAccount, Model model) {
        model.addAttribute("postingHistory", postingService.getPostingHistory(userAccount.getUserId()));
        model.addAttribute("otherPostingHistory", postingService.getOtherLatestHistory(userAccount.getUserId()));
        model.addAttribute("userName", userAccount.getUsername());
        return "index";
    }
}
