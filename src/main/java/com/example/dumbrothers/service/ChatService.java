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
    //http://203.255.3.32:8001/chat/?metaTags
    public String getTags(String parameterValue) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://203.255.3.32:8001")
                .path("/chat/")
                .queryParam("metaTags", parameterValue) // 쿼리 파라미터 추가
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