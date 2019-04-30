package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.*;
import com.netcracker.projectmanager.services.ConverterDataService;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.ArrayList;
import java.util.List;
@Service
public class ConverterDataServiceImpl implements ConverterDataService  {

//    @Override
//    public Task convertViewModelToTask(TaskViewModel taskViewModel) {
//        Task task = new Task();
////        task.setStatus(taskViewModel.getStatus());
////        task.setId(taskViewModel.getId());
////        task.setAssignedUser(taskViewModel.getAssignedUser());
////        task.setCreatedDate(taskViewModel.getCreatedDate());
////        task.setUpdatedDate(taskViewModel.getUpdatedDate());
////        task.setEstimation(taskViewModel.getEstimation());
////        task.setDescription(taskViewModel.getDescription());
////        task.setDueDate(taskViewModel.getDueDate());
////        task.setPriority(taskViewModel.getPriority());
////        task.setProjectCode(taskViewModel.getProjectCode());
////        task.setReporter(taskViewModel.getReporter());
////        task.setTaskCode(taskViewModel.getTaskCode());
//        return task;
//
//    }
//
//    @Override
//    public TaskViewModel convertTaskToViewModel(Task task) {
////        TaskViewModel taskViewModel = new TaskViewModel();
////        taskViewModel.setAssignedUser(task.getAssignedUser().getId());
////        taskViewModel.setDescription(task.getDescription());
////        taskViewModel.setCreatedDate(task.getCreatedDate());
////        taskViewModel.setDueDate(task.getDueDate());
////        taskViewModel.setId(task.getId());
////        taskViewModel.setEstimation(task.getEstimation());
////        taskViewModel.setUpdatedDate(task.getUpdatedDate());
////        taskViewModel.setPriority(task.getPriority().getPriorityName());
////        taskViewModel.setProjectCode(task.getProjectCode().getProjectCode());
////        taskViewModel.setStatus(task.getStatus().getStatus());
////        taskViewModel.setTaskCode(task.getTaskCode());
////        taskViewModel.setReporter(task.getReporter().getId());
////        return taskViewModel;
//
//        TaskViewModel taskViewModel = new TaskViewModel();
////        taskViewModel.setAssignedUser(task.getAssignedUser());
////        taskViewModel.setDescription(task.getDescription());
////        taskViewModel.setCreatedDate(task.getCreatedDate());
////        taskViewModel.setDueDate(task.getDueDate());
////        taskViewModel.setId(task.getId());
////        taskViewModel.setEstimation(task.getEstimation());
////        taskViewModel.setUpdatedDate(task.getUpdatedDate());
////        taskViewModel.setPriority(task.getPriority());
////        taskViewModel.setProjectCode(task.getProjectCode());
////        taskViewModel.setStatus(task.getStatus());
////        taskViewModel.setTaskCode(task.getTaskCode());
////        taskViewModel.setReporter(task.getReporter());
//        return taskViewModel;
//    }
//
//    @Override
//    public TaskViewModel[] convertTasksToViewModels(List<Task> tasks) {
//        TaskViewModel[] taskViewModels = new TaskViewModel[tasks.size()];
//        for (int i = 0; i < tasks.size(); i++) {
//            taskViewModels[i] = convertTaskToViewModel(tasks.get(i));
//        }
//        return taskViewModels;
//    }

    @Override
    public ProjectViewModel convertProjectToViewModel(Project project) {
        ProjectViewModel projectViewModel = new ProjectViewModel();
        projectViewModel.setId(project.getId());
        projectViewModel.setProjectCode(project.getProjectCode());
        projectViewModel.setSummary(project.getSummary());
        return projectViewModel;
    }

    @Override
    public Project convertToProject(ProjectViewModel projectViewModel) {
        Project project = new Project();
        project.setId(project.getId());
        project.setSummary(projectViewModel.getSummary());
        project.setProjectCode(projectViewModel.getProjectCode());
        return project;
    }

    @Override
    public User convertFromViewModelToUser(LoginUser loginUser) {
        return null;
    }


}
