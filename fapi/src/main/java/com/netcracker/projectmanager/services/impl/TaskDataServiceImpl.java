package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.Task;
import com.netcracker.projectmanager.services.TaskDataService;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TaskDataServiceImpl implements TaskDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public List<Task> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Task[] tasks = restTemplate.getForObject(backendServerUrl+"api/tasks", Task[].class);
        return tasks == null ? Collections.emptyList() : Arrays.asList(tasks);
    }

    @Override
    public List<Task> getTasksByProjectId(Integer projectId) {
        RestTemplate restTemplate = new RestTemplate();
        Task[] tasks =  restTemplate.getForObject(backendServerUrl+"/api/tasks/project/" + projectId, Task[].class);
        return tasks == null ? Collections.emptyList() : Arrays.asList(tasks);
    }

    @Override
    public Task getTasksById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"/api/tasks/" + id, Task.class);
    }

    @Override
    public Task saveTask(Task task) {
        if (task == null){ throw new NullPointerException("Task is null");}
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/tasks",task,Task.class).getBody();
    }

    @Override
    public void deleteTaskById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl+"/api/tasks/"+id);
    }
}
