package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.entity.Role;

import java.util.Optional;

public interface RoleService {
    Iterable<Role> getALlRole();
    Optional<Role> getById(Short id);
}
