package com.example.dumbrothers.controller;

import com.example.dumbrothers.dto.FolderForm;
import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.entity.Folder;
import com.example.dumbrothers.repository.FolderRepository;
import com.example.dumbrothers.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {
    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private FolderService folderService;


    @GetMapping("/dum/folder") //폴더를 보여주는 페이지
    public List<Folder> showfolder() {
        return folderService.show();
    }

//    @PostMapping("/dum/folder/add")
//    public Folder create(@RequestBody FolderForm folderForm){
//        Folder folder = folderForm.toEntity();
//        return folderRepository.save(folder);
//
//    }

    @PostMapping("/dum/folder/add")
    public ResponseEntity<Folder> create(@RequestBody FolderForm folderForm){
        Folder folder=folderService.save(folderForm);
        return ResponseEntity.status(HttpStatus.OK).body(folder);

    }

    @PatchMapping("/dum/folder/{id}")
    public ResponseEntity<Folder> update(@PathVariable Long id, @RequestBody FolderForm dto){

        Folder updated=folderService.update(id,dto);
        return (updated!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/dum/folder/{id}")
    public ResponseEntity<Folder> delete(@PathVariable Long id){

        //대상찾기
        Folder target=folderRepository.findById(id).orElse(null);
        //잘못된 요청처리
        if (target == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //대상 삭제
        folderRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

