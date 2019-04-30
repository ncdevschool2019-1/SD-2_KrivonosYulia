package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.entity.Priority;
import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.services.PriorityService;
import com.netcracker.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/priorities")
public class PriorityController {
    @Autowired
    private PriorityService priorityService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Priority> getPriorityById(@PathVariable(name = "id") Short id) {
        Optional<Priority> priority = priorityService.getById(id);
        if (priority.isPresent()) {
            return ResponseEntity.ok(priority.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Priority>> getAll() {
        return ResponseEntity.ok(priorityService.getALl());
    }
}
