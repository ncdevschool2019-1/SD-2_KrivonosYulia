package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.entity.Priority;
import com.netcracker.projectmanager.entity.Status;
import com.netcracker.projectmanager.services.PriorityService;
import com.netcracker.projectmanager.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Status> getPriorityById(@PathVariable(name = "id") Short id) {
        Optional<Status> status = statusService.getById(id);
        if (status.isPresent()) {
            return ResponseEntity.ok(status.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Status>> getAll() {
        return ResponseEntity.ok(statusService.getALl());
    }
}
