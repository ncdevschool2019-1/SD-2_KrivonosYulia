package com.netcracker.projectmanager.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;



public interface FileService {
    void deleteFile(String nameFile);
    Resource getFile(String nameFile);
    String uploadFile(MultipartFile file, String uploadPath) throws Exception;

//    void store(MultipartFile file);//: save a file
//
//    Resource loadFile(String filename);//: load a file
//
//    void deleteAll();//: remove all uploaded files
//
//
//    void init();//: create upload directory
}
