package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.models.Role;
import com.netcracker.projectmanager.services.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Role getById(Short id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"api/roles/"+id, Role.class);
    }

    @Override
    public Iterable<Role> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Role[] roles = restTemplate.getForObject(backendServerUrl+"api/roles", Role[].class);
        return roles == null ? Collections.emptyList() : Arrays.asList(roles);
    }
}
