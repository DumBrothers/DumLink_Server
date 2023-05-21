package com.example.dumbrothers.service;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ChatService {
    private final WebClient webClient;
    private final Logger logger = LoggerFactory.getLogger(ChatService.class);

    public ChatService() {
        this.webClient = WebClient.create();
    }

    public String getTags() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://127.0.0.1:8000")
                .path("/chat/")
                .encode()
                .build()
                .toUri();

        ResponseEntity<String> responseEntity = webClient.get()
                .uri(uri)
                .retrieve()
                .toEntity(String.class)
                .block();

        logger.info("status code: {}", responseEntity.getStatusCode());
        logger.info("body: {}", responseEntity.getBody());

        return responseEntity.getBody();
    }
}

