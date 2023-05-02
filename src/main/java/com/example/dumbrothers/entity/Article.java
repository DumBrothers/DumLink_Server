package com.example.dumbrothers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity//db가 해당 객체를 인식 가능!
@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자를 추가
@ToString
public class Article {

    @Id //대표값 지정
    @GeneratedValue //1,2,3,자동생성 어노테이션
    private Long id;
    @Column
    private String title;
    @Column
    private String content;




}
