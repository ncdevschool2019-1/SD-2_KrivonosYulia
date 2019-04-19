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
    public Task getTasksById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"/api/billing-tasks/" + id, Task.class);

    }

    @Override
    public Task saveTask(Task account) {
        return null;
    }

    @Override
    public void deleteTaskById(Integer id) {

    }
}
