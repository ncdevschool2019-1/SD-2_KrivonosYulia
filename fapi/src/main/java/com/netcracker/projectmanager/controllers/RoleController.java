package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.models.Priority;
import com.netcracker.projectmanager.models.Project;
import com.netcracker.projectmanager.models.Role;
import com.netcracker.projectmanager.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/roles")
public class RoleController {

        @Autowired
        private RoleService roleDataService;

        @RequestMapping
        public ResponseEntity<List<Role>> getAllRoles(){
            List<Role> roles = (List<Role>) roleDataService.getAll();
            return ResponseEntity.ok(roles);
        }

    }
