package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.models.User;
import com.netcracker.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

@Service
public class UserServiceImpl implements UserService { //implements UserDetailsService,
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public User findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForEntity(backendServerUrl + "/api/users/login/" + login, User.class).getBody();
        return user;
    }

    @Override
    public List<User> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/users", User[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public User save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users", user, User.class).getBody();
    }
}
