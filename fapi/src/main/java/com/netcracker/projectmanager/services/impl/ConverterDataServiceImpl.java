package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.*;
import com.netcracker.projectmanager.services.ConverterDataService;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.ArrayList;
import java.util.List;
@Service
public class ConverterDataServiceImpl implements ConverterDataService  {

    @Override
    public Task convertViewModelToTask(TaskViewModel taskViewModel) {

        return null;
    }

    @Override
    public TaskViewModel convertTaskToViewModel(Task task) {
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setAssignedUser(task.getAssignedUser().getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCreatedDate(task.getCreatedDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setId(task.getId());
        taskViewModel.setEstimation(task.getEstimation());
        taskViewModel.setUpdatedDate(task.getUpdatedDate());
        taskViewModel.setPriority(task.getPriority().getPriorityName());
        taskViewModel.setProjectCode(task.getProjectCode().getProjectCode());
        taskViewModel.setStatus(task.getStatus().getStatus());
        taskViewModel.setTaskCode(task.getTaskCode());
        taskViewModel.setReporter(task.getReporter().getId());
        return taskViewModel;
    }

    @Override
    public TaskViewModel[] convertTasksToViewModels(List<Task> tasks) {
        TaskViewModel[] taskViewModels = new TaskViewModel[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            taskViewModels[i] = convertTaskToViewModel(tasks.get(i));
        }
        return taskViewModels;
    }

    @Override
    public User convertFromViewModelToUser(LoginUser loginUser) {
        return null;
    }

    @Override
    public Task convertViewModelToNewTask(NewTasksViewModel newTaskViewModel) {
        return null;
    }
}
