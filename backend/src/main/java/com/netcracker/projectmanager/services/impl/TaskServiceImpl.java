package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.entity.Task;
import com.netcracker.projectmanager.repositories.TaskRepository;
import com.netcracker.projectmanager.services.ProjectService;
import com.netcracker.projectmanager.services.TaskService;
import com.netcracker.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {



    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task findById(Integer id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findByUserReporter(String email) {

        return taskRepository.findByReporter(userService.findByEmail(email));
    }

    @Override
    public List<Task> findByUserAssigned(String email) {
        return taskRepository.findByAssignedUser(userService.findByEmail(email));
    }

    @Override
    public List<Task> findByProjectCode(String projectCode) {
        Project project = projectService.findByProjectCode(projectCode);
        return taskRepository.findByProjectCode(project);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Integer id) {
        taskRepository.delete(taskRepository.findById(id).get());
    }
}
