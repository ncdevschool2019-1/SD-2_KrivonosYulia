package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.entity.Task;
import com.netcracker.projectmanager.entity.User;
import com.netcracker.projectmanager.repositories.TaskRepository;
import com.netcracker.projectmanager.services.ProjectService;
import com.netcracker.projectmanager.services.TaskService;
import com.netcracker.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

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
        Optional<Task> task = taskRepository.findById(id);

        return taskRepository.findById(id).get();

//        else throw new RuntimeException("Invalid id");
    }

    @Override
    public List<Task> findByUserReporter(String email) {
        User user = userService.findByEmail(email);
        if(user != null){
            return taskRepository.findByReporter(user);
        }
        else {
            throw new RuntimeException("Invalid email. User with such email is not exist");
        }
    }

    @Override
    public List<Task> findByUserAssigned(String email) {

        User user = userService.findByEmail(email);
        if(user != null){
            return taskRepository.findByAssignedUser(user);
        }
        else {
            throw new RuntimeException("Invalid email. User with such email is not exist");
        }
    }

    @Override
    public List<Task> findByProjectCode(String projectCode) {
        Project project = projectService.findByProjectCode(projectCode);
        if(project!= null){
            return taskRepository.findByProjectCode(project);
        }
       else {
           return null;
        }
    }


    @Override
    public List<Task> findByProjectId(Integer projectId) {
        Project project = projectService.findById(projectId);
        if(project!= null){
            return taskRepository.findByProjectCode(project);
        }
        else {
            return null;
        }
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);


    }

    @Override
    public void delete(Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(task1 -> taskRepository.delete(task1));
    }
}
