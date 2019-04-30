package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.Role;
import com.netcracker.projectmanager.repositories.RoleRepository;
import com.netcracker.projectmanager.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> getALlRole() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getById(Short role) {
        return roleRepository.findById(role);
    }
}
