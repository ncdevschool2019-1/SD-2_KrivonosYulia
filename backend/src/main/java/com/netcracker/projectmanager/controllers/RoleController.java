package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.entity.Priority;
import com.netcracker.projectmanager.entity.Role;
import com.netcracker.projectmanager.repositories.RoleRepository;
import com.netcracker.projectmanager.services.PriorityService;
import com.netcracker.projectmanager.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Role> getPriorityById(@PathVariable(name = "id") Short id) {
        Optional<Role> role= roleService.getById(id);
        if (role.isPresent()) {
            return ResponseEntity.ok(role.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Role>> getAllRole() {
        return ResponseEntity.ok(roleService.getALlRole());
    }
}
