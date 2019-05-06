package com.netcracker.projectmanager.controllers;

import com.netcracker.projectmanager.entity.User;
import com.netcracker.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login/{email}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "email") String email ){
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

//    @RequestMapping(value = "/image/{imageName:.+}", method = RequestMethod.GET)
//    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
//        Resource image = null;
//        try {
//            image = this.userService.getImage(imageName);
//            if(!image.isReadable()){
//                image = null;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok(image);
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void deleteUserById(@PathVariable(name = "id") Long id) {
//        User user = this.userService.getUserById(id);
//        if (user != null) {
//            if(user.getImagePath() != null) {
//                this.userService.deleteImage(this.userService.getUserById(id).getImagePath());
//            }
//            this.userService.deleteUser(id);
//        }
//    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
