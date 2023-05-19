package com.example.dumbrothers.controller;

import com.example.dumbrothers.DuMbrothersApplication;
import com.example.dumbrothers.dto.DumForm;
import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.repository.DumRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@Slf4j
public class FirstController {
    @Autowired
    private DumRepository dumRepository;

    @GetMapping("/dum")
    public List<Dum> dum(Model modle){
        return dumRepository.findAll();
    }

    @PostMapping("/dum/input")
    public Dum create(@RequestBody DumForm form){
        Dum dum=form.toEntity();
        return dumRepository.save(dum);
    }


    @DeleteMapping("dum/{id}")
    public ResponseEntity<Dum> delete(@PathVariable Long id){

        //대상찾기
        Dum target=dumRepository.findById(id).orElse(null);
        //잘못된 요청처리
        if (target == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //대상 삭제
        dumRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
