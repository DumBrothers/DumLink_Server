package com.example.dumbrothers.service;

import com.example.dumbrothers.connect.LinkScrap;
import com.example.dumbrothers.dto.DumForm;
import com.example.dumbrothers.dto.FolderForm;
import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.entity.Folder;
import com.example.dumbrothers.repository.DumRepository;
import com.example.dumbrothers.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dumbrothers.controller.ChatController;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class DumService {

    @Autowired
    private DumRepository dumRepository;

    @Autowired
    private FolderRepository folderRepository;
    private ChatService chatService;
    public DumService(ChatService chatService) {
        this.chatService = chatService;
    }

    public DumForm create(DumForm dto) {
        Long dumNum=dto.getFolderId();
        if (dumNum==null) {
            dumNum=1L;
        }
        String url = dto.getLink();

        try {
            Map<String, String> ogTag = LinkScrap.handleSendText(url);
            System.out.println("########"+ogTag.get("title")+"#######" + ogTag.get("image")+ogTag.get("description")+ogTag.get("head"));
            if(ogTag.get("title")==null)
                dto.setTitle(ogTag.get("head"));
            else
                dto.setTitle(ogTag.get("title"));
            dto.setImage(ogTag.get("image"));
            dto.setDescription(ogTag.get("description"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String parameterValue = dto.getDescription() + dto.getTitle();
        String input = chatService.getTags(parameterValue);
        input = input.substring(2, input.length() - 2);
        String[] tags = input.split("\",\"");


        if(tags[0].length() < 8) {
            dto.setFirstTag(tags[0]);
        } else { dto.setFirstTag("기타");}

        if(tags[1].length() < 8) {
            dto.setSecondTag(tags[1]);
        } else { dto.setSecondTag("기타");}

        if(tags[2].length() < 8) {
            dto.setThirdTag(tags[2]);
        } else { dto.setThirdTag("기타");}

        Folder folder = folderRepository.findById(dumNum)
                .orElseThrow(()->new IllegalArgumentException("주소 생성 실패 대상 폴더가 없습니다"));

        Dum dum=Dum.createDum(dto,folder);
        Dum created=dumRepository.save(dum);

        return DumForm.createlinkDto(created);
    }

    public List<Dum> inshow(Long id) {
        List<Dum> dumList;

        try {
            dumList = (List<Dum>) show().stream()
                    .filter(dum -> dum.showFolderId().equals(id))
                    .toList();
        } catch (Exception e) {
            // 로깅, 오류 추적 및 처리를 수행하십시오.
            dumList = Collections.emptyList();
        }
        return dumList;
    }

    public List<Dum> show() {
        return dumRepository.findAllOrderByDescId();
    }

//    public Dum create(DumForm dto) {
//        Dum dum=dto.toEntity();
//        if(dum.getId()!=null)
//            return null;
//        return dumRepository.save(dum);
//    }

    public Dum delete(Long id) {
        //대상찾기
        Dum target=dumRepository.findById(id).orElse(null);
        //잘못된 요청처리
        if (target == null){
            return null;
        }

        //대상 삭제
        dumRepository.delete(target);
        return target;
    }

    public List<String> tags() {

        List<String> tagList =  show().stream()
                .flatMap(dum -> dum.showTags().stream())
                .distinct()
                .collect(Collectors.toList());

        Collections.sort(tagList);
        return tagList;
    }

    public List<Dum> tagsearch(String tags) {
        List<Dum> dumList;

        try {
            dumList = (List<Dum>) show().stream()
                    .filter(dum -> dum.showTags().contains(tags))
                    .toList();
        } catch (Exception e) {
            // 로깅, 오류 추적 및 처리를 수행하십시오.
            dumList = Collections.emptyList();
        }
        return dumList;
    }

    public Dum update(Long id, DumForm dto) {
        //댓글 조회 및 예외 발생
        Dum target=  dumRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("댓글 수정실패 대상 댓글이 없습니다")
                );

        Long a=dto.getFolderId();
        Folder folder =folderRepository.findById(a)
                .orElseThrow(()->new IllegalArgumentException("폴더가 없어요")
                );

        target.setFolder(folder);
        Dum b = dumRepository.save(target);

        return target;
    }

}
