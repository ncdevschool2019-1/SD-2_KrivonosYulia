package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.Role;

public interface RoleService {
    Role getById(Short id);
    Iterable<Role> getAll();
}
