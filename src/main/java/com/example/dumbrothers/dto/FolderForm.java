package com.example.dumbrothers.dto;

import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.entity.Folder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
public class FolderForm {
    private Long folderId;
    private String folderName;
    private Long userId;


    public Folder toEntity(){

        return new Folder(null, folderName, userId);

    }
}