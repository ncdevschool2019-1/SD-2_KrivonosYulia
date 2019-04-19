package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.*;

import java.util.List;

public interface ConverterDataService {
    Task convertViewModelToTask(TaskViewModel taskViewModel);
    TaskViewModel convertTaskToViewModel(Task task);
    TaskViewModel[] convertTasksToViewModels(List<Task> tasks);

    User convertFromViewModelToUser(LoginUser loginUser);
    Task convertViewModelToNewTask(NewTasksViewModel newTaskViewModel);


}
