package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.Status;

public interface StatusService {
    Status getById(Short id);
    Iterable<Status> getAll();
}
