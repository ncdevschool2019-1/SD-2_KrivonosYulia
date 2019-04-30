package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(Integer id);
     List<Task> findByProjectId(Integer projectId);
    List<Task> findByUserReporter(String login);
    List<Task> findByUserAssigned(String login);
    List<Task> findByProjectCode(String projectCode);


    Task save(Task task);
    void delete(Integer id);
}
