package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseEntity<Page<Project>> getAllPageable(  @RequestParam("page") int page,
                                                          @RequestParam("size") int size,
                                                          @RequestParam("sort") String property,
                                                          @RequestParam("direction") Sort.Direction direction) {
        Pageable pageable =PageRequest.of(page, size, direction, property);
        return ResponseEntity.ok(projectService.findAll(pageable));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @RequestMapping(value = "/page/{projectCode}", method = RequestMethod.GET)
    public ResponseEntity<Page<Project>> getByProjectPage(@PathVariable (value = "projectCode") String projectCode,
                                                          @RequestParam("page") int page,
                                                          @RequestParam("size") int size,
                                                          @RequestParam("sort") String property,
                                                          @RequestParam("direction") Sort.Direction direction) {
        Pageable pageable =PageRequest.of(page, size, direction, property);
        return ResponseEntity.ok(projectService.findAllByProjectCodeLike(projectCode, pageable));

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
