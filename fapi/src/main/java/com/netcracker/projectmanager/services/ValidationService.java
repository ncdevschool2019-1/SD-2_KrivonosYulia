package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.User;

import java.util.List;

public interface ValidationService {
    String authorizationValidation(String email, String password);
    String registrationValidation(User userModel, List<User> usersModels);
    String updateUsersEmailValidation(User userViewModel);
}
