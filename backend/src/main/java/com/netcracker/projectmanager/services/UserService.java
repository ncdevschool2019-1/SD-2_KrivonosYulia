package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByEmail(String login);

    User save(User user);
    void delete(Integer id);
}
