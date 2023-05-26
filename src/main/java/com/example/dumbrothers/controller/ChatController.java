package com.example.dumbrothers.controller;

import com.example.dumbrothers.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/getTags")
    public String getTags(@RequestParam("metaTags") String parameterValue) {
        return chatService.getTags(parameterValue);
    }
}