package com.example.dumbrothers.dto;

import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.entity.Folder;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
public class DumForm {
    private Long id;
    private String link;
    private String firstTag;
    private String secondTag;
    private String thirdTag;
    private Long userId;
    private Long folderId;

    public Dum toEntity(){
            return new Dum(id, link, firstTag, secondTag, thirdTag, userId,folderId);

    }
}
