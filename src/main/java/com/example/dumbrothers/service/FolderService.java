package com.example.dumbrothers.service;

import com.example.dumbrothers.dto.FolderForm;
import com.example.dumbrothers.entity.Folder;
import com.example.dumbrothers.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;
    public List<Folder> show() {
        return folderRepository.findAll();
    }

    public Folder save(FolderForm folderdto) {
        Folder folder = folderdto.toEntity();
        Folder foldercreate=folderRepository.save(folder);
        return foldercreate;
    }
}
