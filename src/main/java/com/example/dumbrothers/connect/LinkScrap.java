package com.example.dumbrothers.connect;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.data.util.Pair;

import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;



public class LinkScrap {
    private final static String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36";
    public static Map<String, String> handleSendText(String url) throws IOException {

        Map<String, String> ogMap = new LinkedHashMap<>();
        Document document = Jsoup.connect(url).userAgent(DEFAULT_USER_AGENT).get();

        Elements elements = document.select("meta[property^=og:]");

        if (!elements.isEmpty()) {
            for (int i = 0; i < elements.size(); i++) {
                switch (elements.get(i).attr("property")) {
                    case "og:image":
                        String content = elements.get(i).attr("content");
                        if (content != null) {
                            ogMap.put("image", content);
                            break;
                        }
                    case "og:url":
                        if (elements.get(i).attr("content") != null) {
                            ogMap.put("url", elements.get(i).attr("content"));
                            break;
                        }
                    case "og:title":
                        if (elements.attr("title") != null) {
                            ogMap.put("title", elements.get(0).attr("content"));
                            break;
                        }
                    case "og:description":
                        if (elements.get(i).attr("content") != null) {
                            ogMap.put("description", elements.get(i).attr("content"));
                            break;
                        }
                    case "og:site_name":
                        if (elements.get(i).attr("content") != null) {
                            ogMap.put("site_name", elements.get(i).attr("content"));
                            break;
                        }
                }
            }
        }
        else{
            ogMap.put("image", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FuJlIh%2FbtsiPPsXB4u%2FqwPqKXFKdkwpz7PBVItyoK%2Fimg.png");
            ogMap.put("title", document.select("head > title").text());
        }


        return ogMap;
    }
}