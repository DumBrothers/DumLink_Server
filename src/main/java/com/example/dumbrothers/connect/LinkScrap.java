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
    public static Map<String, String> handleSendText(String url) throws IOException {
        Map<String, String> ogMap = new LinkedHashMap<>();
        Document document = Jsoup.connect(url).userAgent("Android").get();

        Elements elements = document.select("meta[property^=og:]");

        ogMap.put("head",document.select("head title").text());

        if (elements != null) {
            for (int i = 0; i < elements.size(); i++) {
                switch (elements.get(i).attr("property")) {
                    case "og:image":
                        String content = elements.get(i).attr("content");
                        if (content != null) {
                            ogMap.put("image", content);
                            break;
                        }
                    case "og:title":
                        if (elements.get(i).attr("content") != null) {
                            ogMap.put("title", elements.get(i).attr("content"));
                            break;
                        }
                    case "og:url":
                        if (elements.get(i).attr("content") != null) {
                            ogMap.put("url", elements.get(i).attr("content"));
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

        return ogMap;
    }
}


