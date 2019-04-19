package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.services.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectDataController {

    @Autowired
    private ProjectDataService projectDataService;

    @RequestMapping
    public ResponseEntity<List<Project>> getAllTasks(){
        List<Project> projects = projectDataService.getAll();
        return ResponseEntity.ok(projects);
    }
}
