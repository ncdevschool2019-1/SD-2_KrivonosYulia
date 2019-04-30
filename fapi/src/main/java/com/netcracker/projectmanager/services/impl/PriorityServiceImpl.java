package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.Priority;
import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.services.PriorityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public Priority getById(Short id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"api/priorities/"+id, Priority.class);
    }

    @Override
    public Iterable<Priority> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Priority[] priorities = restTemplate.getForObject(backendServerUrl+"api/priorities", Priority[].class);
        return priorities == null ? Collections.emptyList() : Arrays.asList(priorities);
    }
}
