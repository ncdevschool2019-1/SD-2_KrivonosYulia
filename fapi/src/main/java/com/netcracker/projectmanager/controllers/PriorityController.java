package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.models.Priority;
import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.services.PriorityService;
import com.netcracker.projectmanager.services.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/priorities")
public class PriorityController {
    @Autowired
    private PriorityService priorityDataService;

    @RequestMapping
    public ResponseEntity<List<Priority>> getAllPriorities(){
        List<Priority> priorities = (List<Priority>) priorityDataService.getAll();
        return ResponseEntity.ok(priorities);
    }

}
