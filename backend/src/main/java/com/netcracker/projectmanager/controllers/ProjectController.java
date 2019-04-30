package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
     private ProjectService projectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Project> getProjectById(@PathVariable(name = "id") Integer id) {
       Project project = projectService.findById(id);
        if (project != null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Project>> getAll() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Project> saveProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.save(project));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProject(@PathVariable(name = "id") Integer id) {
        projectService.delete(id);
        return ResponseEntity.ok().build();
    }


}
