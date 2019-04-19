package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.models.Task;
import com.netcracker.projectmanager.models.TaskViewModel;
import com.netcracker.projectmanager.services.ConverterDataService;
import com.netcracker.projectmanager.services.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskDataController {

    @Autowired
    private TaskDataService taskDataService;

    @Autowired
    private ConverterDataService converterDataService;

    @RequestMapping
    public ResponseEntity<TaskViewModel[]> getAllTasks(){
        TaskViewModel[] taskViewModel = converterDataService.convertTasksToViewModels(taskDataService.getAll());
        return ResponseEntity.ok(taskViewModel);

    }


}
