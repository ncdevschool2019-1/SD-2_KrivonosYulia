package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.models.ProjectViewModel;
import com.netcracker.projectmanager.services.ConverterDataService;
import com.netcracker.projectmanager.services.ProjectDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectDataController {

    @Autowired
    private ProjectDataService projectDataService;
    @Autowired
    private ConverterDataService converterDataService;


    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getAllProjectPageable(@RequestParam("page") int page,
                                                               @RequestParam("size") int size,
                                                               @RequestParam("sort") String properties,
                                                               @RequestParam("direction") Sort.Direction direction){
        List<Project> projects = projectDataService.getAll(page, size,direction, properties);
        return ResponseEntity.ok(projects);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getAllProject(){
        List<Project> projects = projectDataService.getAll();
        return ResponseEntity.ok(projects);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Project> saveProject(@RequestBody ProjectViewModel projectView){
        Project project = converterDataService.convertToProject(projectView);
        if(project != null){
            return ResponseEntity.ok(projectDataService.save(project));
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProject(@PathVariable Integer id){
        projectDataService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Project> getProjectById(@PathVariable Integer id){
        Project project = projectDataService.getById(id);
        return project!=null? ResponseEntity.ok(project): ResponseEntity.ok().build();
    }
}
