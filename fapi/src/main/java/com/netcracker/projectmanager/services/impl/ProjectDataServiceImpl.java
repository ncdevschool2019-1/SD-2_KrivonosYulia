package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.models.RestCustomPage;
import com.netcracker.projectmanager.services.ProjectDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;


    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Project> getAll() {
        Project[] projects = restTemplate.getForObject(backendServerUrl+"api/projects", Project[].class);
        return projects == null ? Collections.emptyList() : Arrays.asList(projects);
    }

    @Override
    public List<Project> getAll(int page, int size, Sort.Direction direction, String properties) {


        ParameterizedTypeReference<RestCustomPage<Project>> responseType =
                new ParameterizedTypeReference<RestCustomPage<Project>>() {
                };

        URI target = UriComponentsBuilder.fromUriString(backendServerUrl)
                .path("api/projects/page")
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("sort", properties)
                .queryParam("direction", direction)
                .build()
                .toUri();
        return restTemplate.exchange(target, HttpMethod.GET, null, responseType).getBody().getContent();

    }



    @Override
    public Page<Project> getAllByPartProjectCode(String projectCode, Pageable pageable) {
        return null;
    }

    @Override
    public Project getById(Integer id) {

        return restTemplate.getForObject(backendServerUrl+"/api/projects"+id, Project.class);

    }


    @Override
    public Project save(Project project) {

        return restTemplate.postForEntity(backendServerUrl+ "/api/projects", project, Project.class).getBody();
    }

    @Override
    public void delete(Integer id) {

        restTemplate.delete(backendServerUrl + "/api/projects/" +  id);
    }


}
