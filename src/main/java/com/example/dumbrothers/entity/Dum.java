package com.example.dumbrothers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Dum {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String link;
    @Column
    private String firstTag;
    @Column
    private String secondTag;
    @Column
    private String thirdTag;



}
