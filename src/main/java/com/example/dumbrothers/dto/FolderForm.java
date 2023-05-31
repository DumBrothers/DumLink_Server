package com.example.dumbrothers.dto;

import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.entity.Folder;
import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
public class FolderForm {
    private Long folderId;
    private String folderName;
    private Long userId;
    private Long urlCounter;

    public Folder toEntity(){
        return new Folder(folderId, folderName, userId, urlCounter);
    }

}
