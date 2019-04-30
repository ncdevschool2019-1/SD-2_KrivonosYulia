package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.Task;

import java.util.List;

public interface TaskDataService {
    List<Task> getAll();
    List<Task> getTasksByProjectId(Integer projectId);
    Task getTasksById(Integer id);
    Task saveTask(Task account);
    void deleteTaskById(Integer id);
}
