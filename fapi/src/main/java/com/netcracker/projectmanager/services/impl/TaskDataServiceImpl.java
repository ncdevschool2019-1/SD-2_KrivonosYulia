package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.models.RestCustomPage;
import com.netcracker.projectmanager.models.Task;
import com.netcracker.projectmanager.services.FileService;
import com.netcracker.projectmanager.services.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TaskDataServiceImpl implements TaskDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private FileService fileService;

    @Override
    public List<Task> getAll() {
        restTemplate = new RestTemplate();
        Task[] tasks = restTemplate.getForObject(backendServerUrl + "api/tasks", Task[].class);
        return tasks == null ? Collections.emptyList() : Arrays.asList(tasks);
    }


    @Override
    public List<Task> getAllPageable(int page, int size, String property, Sort.Direction direction) {


        ParameterizedTypeReference<RestCustomPage<Task>> responseType =
                new ParameterizedTypeReference<RestCustomPage<Task>>() {
                };


        URI target = UriComponentsBuilder.fromUriString(backendServerUrl)
                .path("api/tasks/page")
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("sort", property)
                .query(",")
                .query(""+direction)
                .build()
                .toUri();
        return restTemplate.exchange(target, HttpMethod.GET, null, responseType).getBody().getContent();
    }



    @Override
    public List<Task> getTasksByProjectId(Integer projectId) {
         restTemplate = new RestTemplate();
        Task[] tasks =  restTemplate.getForObject(backendServerUrl+"/api/tasks/project/" + projectId, Task[].class);
        return tasks == null ? Collections.emptyList() : Arrays.asList(tasks);
    }

    @Override
    public Task getTasksById(Integer id) {
         restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"/api/tasks/" + id, Task.class);
    }

    @Override
    public Task saveTask(Task task) {
        if (task == null){ throw new NullPointerException("Task is null");}
         restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/tasks",task,Task.class).getBody();
    }

    @Override
    public Task uploadAttachments(MultipartFile file, Long id) {
        Task task = restTemplate.postForEntity(backendServerUrl + "/file/" + id,
                fileService.uploadFile(file), Task.class).getBody();
        if (task != null) {
            return task;
        }
        return null;
    }



    @Override
    public void deleteTaskById(Integer id) {
         restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl+"/api/tasks/"+id);
    }



}
