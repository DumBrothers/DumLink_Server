package com.example.dumbrothers.dto;


import com.example.dumbrothers.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //생성자를 안적어도 되게함
@ToString
public class ArticleForm {

    private long id;
    private String title;
    private String content;
    public Article toEntity() {
        return new Article(id,title,content);
    }


}
