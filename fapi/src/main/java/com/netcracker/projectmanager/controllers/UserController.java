package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.models.User;
import com.netcracker.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return  ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/login/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }
}
