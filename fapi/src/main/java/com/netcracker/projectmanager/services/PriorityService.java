package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.Priority;

import java.util.List;

public interface PriorityService {
    Priority getById(Short id);
    Iterable<Priority> getAll();
}
