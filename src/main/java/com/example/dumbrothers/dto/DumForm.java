package com.example.dumbrothers.dto;

import com.example.dumbrothers.entity.Dum;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class DumForm {
    private String link;
    public Dum toEntity(){
        return new Dum(null,link);
    }
}
