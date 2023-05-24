package com.example.dumbrothers.entity;

import com.example.dumbrothers.dto.DumForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

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

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    public static Dum createDum(DumForm dto, Folder folder) {
        //if (dto.getId() != null)
           // throw new IllegalArgumentException("링크생성 실패 댓글의 id가 잇어야함");

  //      if (dto.getFolderId() != folder.getFolderId())
   //         throw new IllegalArgumentException("링크생성 실패 id가 잘못되엇음");
        return new Dum(
                dto.getId(),
                dto.getLink(),
                dto.getFirstTag(),
                dto.getSecondTag(),
                dto.getThirdTag(),
                dto.getUserId(),
                folder
        );
    }
}

