package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.models.Status;
import com.netcracker.projectmanager.services.ProjectDataService;
import com.netcracker.projectmanager.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusController {


        @Autowired
        private StatusService statusDataService;

        @RequestMapping
        public ResponseEntity<List<Status>> getAllStatus(){
            List<Status> statuses = (List<Status>) statusDataService.getAll();
            return ResponseEntity.ok(statuses);
        }
}


//    @RequestMapping
//    public ResponseEntity<Status> getStatusById(@PathVariable(name = "id")  Short id){
//        return ResponseEntity.ok(statusDataService.getById(id));
//        }
//
//    }
