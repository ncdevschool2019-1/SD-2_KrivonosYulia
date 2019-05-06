package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.services.FileService;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

//    private final Path rootLocation = Paths.get("upload-dir");
//
//    @Override
//    public void store(MultipartFile file) {
//        try {
//            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
//        } catch (Exception e) {
//            throw new RuntimeException("FAIL!");
//        }
//    }
//
//    @Override
//    public Resource loadFile(String filename) {
//        return null;
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public void init() {
//
//    }

    @Override
    public void deleteFile(String nameFile) {
        String imageDir = nameFile.substring(0, nameFile.indexOf('_'));
        String path = "backend/src/images/usersImages/";
        File file = new File(path, imageDir + "/" + nameFile);
        try {
            file.delete();
            if (!file.exists()) {
                new File(path, imageDir).delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resource getFile(String nameFile) {
        try {
            String imageDir = nameFile.substring(0, nameFile.indexOf('_')) + "/" + nameFile;
            Path file = Paths.get("backend/src/images/usersImages/" + imageDir);
            return new UrlResource(file.toUri());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String uploadFile(MultipartFile file, String uploadPath) throws IOException  {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();

            File dir = new File(uploadPath + File.separator + "tmpFiles");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            File uploadedFile = new File(dir.getAbsolutePath() + File.separator + resultFilename);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
            stream.write(bytes);
            stream.flush();
            stream.close();
            return resultFilename;
        } else {

            return null;
        }
    }

}
