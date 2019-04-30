package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.models.Task;
import com.netcracker.projectmanager.services.ConverterDataService;
import com.netcracker.projectmanager.services.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskDataController {

    @Autowired
    private TaskDataService taskDataService;

    @Autowired
    private ConverterDataService converterDataService;

    @RequestMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> task = taskDataService.getAll();
        return ResponseEntity.ok(task);

    }

    @RequestMapping(value = "/project/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable(name = "id") Integer id){
        List<Task> task = taskDataService.getTasksByProjectId(id);
        return ResponseEntity.ok(task);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
//        Task task = converterDataService.convertViewModelToTask(taskViewModel);
        if(task != null){
            return ResponseEntity.ok(taskDataService.saveTask(task));
        }
        System.out.println("task is null");
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable Integer id){
        taskDataService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id){
        Task task = taskDataService.getTasksById(id);
        return task!=null? ResponseEntity.ok(task): ResponseEntity.ok().build();
    }



}
