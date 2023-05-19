package com.example.dumbrothers.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String link;
    @Column
    private String firstTag;
    @Column
    private String secondTag;
    @Column
    private String thirdTag;
    @Column
    private Long userId;
    @Column
    private Long folderId;


}
