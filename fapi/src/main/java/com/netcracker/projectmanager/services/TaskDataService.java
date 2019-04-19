package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.Task;

import java.util.List;

public interface TaskDataService {
    List<Task> getAll();
    Task getTasksById(Integer id);
    Task saveTask(Task account);
    void deleteTaskById(Integer id);
}
