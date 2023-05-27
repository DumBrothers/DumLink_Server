package com.example.dumbrothers.entity;

import com.example.dumbrothers.dto.DumForm;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
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

    @Column
    private String title;
    @Column
    private String image;
    @Column
    private String description;



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
                folder,
                dto.getTitle(),
                dto.getImage(),
                dto.getDescription()

        );
    }
//    public void patch(DumForm dto) {
//
//        //예외 발생
//        if (this.id != dto.getId())
//            throw new IllegalArgumentException("댓글 수정실패 잘못된 id가 입력");
//        //객체를 갱신
//        System.out.println("#######"+this.folder.getFolderId());
//        if(this.folder.getFolderId()!=null)
//           this.folder.set()=dto.getFolderId();
//        if(dto.getBody()!=null)
//            this.body=dto.getBody();
//    }
}

