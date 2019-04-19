package com.netcracker.projectmanager.controllers;


import com.netcracker.projectmanager.entity.Task;
import com.netcracker.projectmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getBillingAccountById(@PathVariable(name = "id") Integer id) {
        Task task = taskService.findById(id);
        if (task!= null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks() {

        return ResponseEntity.ok(taskService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> saveBillingAccount(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.save(task));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBillingAccount(@PathVariable(name = "id") Integer id) {
        taskService.delete(id);
       return ResponseEntity.ok().build();
    }

}
