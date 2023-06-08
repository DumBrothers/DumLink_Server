package com.example.dumbrothers.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

public class URLUtils {

    public static String getOriginalLink(String url) throws IOException {
        // URL 객체 생성
        URL link = new URL(url);

        // URL 연결 객체 생성
        HttpURLConnection con = (HttpURLConnection) link.openConnection();
        con.setInstanceFollowRedirects(false);

        // 연결 객체에서 Location 헤더 값을 가져오기
        String location = con.getHeaderField("Location");

        // Location 헤더 값이 존재하는 경우,귀적으로 다시 호출하여 원본 URL을 추출
        if (location != null && !location.equals("")) {
            return getOriginalLink(location);
        }

        // URL 연결 객체 종료
        con.disconnect();

        if(url.contains("https://link.naver.com/bridge?url=")){
            return URLDecoder.decode(url.substring(url.indexOf("https://link.naver.com/bridge?url=") + "https://link.naver.com/bridge?url=".length(), url.indexOf("&")), "UTF-8");

        }
        // URL 디코드 후 반환
        return url;
    }
}