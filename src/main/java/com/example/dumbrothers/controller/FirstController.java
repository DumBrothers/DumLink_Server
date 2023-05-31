package com.example.dumbrothers.controller;


import com.example.dumbrothers.dto.DumForm;
import com.example.dumbrothers.entity.Dum;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dumbrothers.service.DumService;

import java.util.List;

@RestController
@Slf4j
public class FirstController {

    @Autowired
    private DumService dumService;

    @GetMapping("/dum")
    public List<Dum> show(){
        return dumService.show();
    }

    @GetMapping("/dum/tags")
    public List<String> tags(){
        return dumService.tags();
    }

    @GetMapping("/dum/tags/{tags}")
    public List<Dum> tags(@PathVariable String tags){
        return dumService.tagsearch(tags);
    }

//    @PostMapping("/dum/input")
//    public ResponseEntity<Dum> create(@RequestBody DumForm dto){
//        Dum create=dumService.create(dto);
//        return (create != null)?
//                ResponseEntity.status(HttpStatus.OK).body(create):
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }

    @GetMapping("/dum/folder/{id}")
    public List<Dum> inshow(@PathVariable Long id){
        return dumService.inshow(id);
    }

    @PostMapping("dum/input")
    public ResponseEntity<DumForm> create(@RequestBody DumForm dto){

        //서비스에게 위임
        DumForm createdDto=dumService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @PatchMapping("dum/{id}")
    public ResponseEntity<Dum> update(@PathVariable Long id, @RequestBody DumForm dto) {

        Dum updatedDto = dumService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @DeleteMapping("dum/{id}")
    public ResponseEntity<Dum> delete(@PathVariable Long id){
        Dum deleted=dumService.delete(id);
       return (deleted != null)?
               ResponseEntity.status(HttpStatus.OK).build():
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
