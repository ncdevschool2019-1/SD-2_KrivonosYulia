package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.User;
import com.netcracker.projectmanager.repositories.UserRepository;
import com.netcracker.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.delete(user.get());
        }
    }
}
