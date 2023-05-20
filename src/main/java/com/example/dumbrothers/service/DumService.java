package com.example.dumbrothers.service;

import com.example.dumbrothers.dto.DumForm;
import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.repository.DumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DumService {

    @Autowired
    private DumRepository dumRepository;

    public List<Dum> show() {
        return dumRepository.findAll();
    }

    public Dum create(DumForm dto) {
        Dum dum=dto.toEntity();
        if(dum.getId()!=null)
            return null;
        return dumRepository.save(dum);
    }

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
