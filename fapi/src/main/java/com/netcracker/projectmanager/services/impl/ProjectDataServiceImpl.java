package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.models.Task;
import com.netcracker.projectmanager.services.ProjectDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Project> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Project[] projects = restTemplate.getForObject(backendServerUrl+"api/projects", Project[].class);
        return projects == null ? Collections.emptyList() : Arrays.asList(projects);
    }

    @Override
    public Project getById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"/api/projects"+id, Project.class);

    }


    @Override
    public Project save(Project project) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl+ "/api/projects", project, Project.class).getBody();
    }

    @Override
    public void delete(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/projects/" +  id);
    }


}
