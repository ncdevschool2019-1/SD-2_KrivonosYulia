package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.models.Status;
import com.netcracker.projectmanager.services.StatusService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class StatusServiceImpl implements StatusService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Status getById(Short id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"api/statuses/"+id, Status.class);
    }

    @Override
    public Iterable<Status> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Status[] statuses = restTemplate.getForObject(backendServerUrl+"api/status", Status[].class);
        return statuses == null ? Collections.emptyList() : Arrays.asList(statuses);
    }
}
