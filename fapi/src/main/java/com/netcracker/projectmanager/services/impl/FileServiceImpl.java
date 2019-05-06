package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.services.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public MultiValueMap<String, Object> uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        try {
            body.add("file", new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }
}
