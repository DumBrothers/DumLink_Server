package com.example.dumbrothers.controller;


import com.example.dumbrothers.connect.LinkScrap;
=
import com.example.dumbrothers.dto.DumForm;
import com.example.dumbrothers.entity.Dum;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dumbrothers.service.DumService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class FirstController {

    @Autowired
    private DumService dumService;


    @GetMapping("/dum")
    public List<Dum> show(){
        return dumService.show();
    }

//    @PostMapping("/dum/input")
//    public ResponseEntity<Dum> create(@RequestBody DumForm dto){
//        Dum create=dumService.create(dto);
//        return (create != null)?
//                ResponseEntity.status(HttpStatus.OK).body(create):
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }

    @PostMapping("dum/input")
    public ResponseEntity<DumForm> create(@RequestBody DumForm dto){


        //서비스에게 위임
        DumForm createdDto=dumService.create(dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

//    @PatchMapping("dum/{id}")
//    public ResponseEntity<DumForm> update(@PathVariable Long id, @RequestBody DumForm dto) {
//
//        DumForm updatedDto = dumService.update(id, dto);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
//    }



    @DeleteMapping("dum/{id}")
    public ResponseEntity<Dum> delete(@PathVariable Long id){
        Dum deleted=dumService.delete(id);
       return (deleted != null)?
               ResponseEntity.status(HttpStatus.OK).build():
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
