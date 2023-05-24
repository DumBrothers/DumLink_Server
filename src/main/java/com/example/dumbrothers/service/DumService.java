package com.example.dumbrothers.service;

import com.example.dumbrothers.dto.DumForm;
import com.example.dumbrothers.dto.FolderForm;
import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.entity.Folder;
import com.example.dumbrothers.repository.DumRepository;
import com.example.dumbrothers.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DumService {

    @Autowired
    private DumRepository dumRepository;
    @Autowired
    private FolderRepository folderRepository;

    public DumForm create(DumForm dto) {

        Long dumNum=dto.getFolderId();
        if (dumNum==null){
            dumNum=1L;
        }

        Folder folder = folderRepository.findById(dumNum)
                .orElseThrow(()->new IllegalArgumentException("주소 생성 실패 대상 폴더가 없습니다"));

        Dum dum=Dum.createDum(dto,folder);
        Dum created=dumRepository.save(dum);

        return DumForm.createlinkDto(created);
    }

    public List<Dum> show() {
        return dumRepository.findAll();
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
}
