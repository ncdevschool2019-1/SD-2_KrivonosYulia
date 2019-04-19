package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);
    List<User> findAll();
    User save(User user);
}
