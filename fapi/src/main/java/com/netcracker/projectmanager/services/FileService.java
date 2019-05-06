package com.netcracker.projectmanager.services;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public MultiValueMap<String, Object> uploadFile(MultipartFile file);
}
