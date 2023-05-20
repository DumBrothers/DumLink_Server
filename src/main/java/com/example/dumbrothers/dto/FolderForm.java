package com.example.dumbrothers.dto;

import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.entity.Folder;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class FolderForm {
    private Long folderId;
    private String folderName;
    private Long userId;


    public Folder toEntity(){

        return new Folder(null, folderName, userId);

    }
}
