package com.example.dumbrothers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folderId;
    @Column
    private String folderName;
    @Column
    private Long userId;



}
