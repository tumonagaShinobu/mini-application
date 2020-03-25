package com.example.miniapplication.controller;

import com.example.miniapplication.controller.config.account.UserAccount;
import com.example.miniapplication.controller.request.PostingRequest;
import com.example.miniapplication.service.PostingService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class StatusController {
    private final PostingService postingService;

    @PostMapping("/posting")
    public String posting(@AuthenticationPrincipal UserAccount userAccount, RedirectAttributes redirectAttributes, @ModelAttribute PostingRequest request) {
        redirectAttributes.addAttribute("isSuccess", postingService.posting(userAccount.getUserId(), request.getPostingMessage()));
        return "redirect:/";
    }
}
