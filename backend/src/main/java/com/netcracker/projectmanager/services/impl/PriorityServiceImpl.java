package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.Priority;
import com.netcracker.projectmanager.repositories.PriorityRepository;
import com.netcracker.projectmanager.services.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriorityServiceImpl implements PriorityService {
    @Autowired
    private PriorityRepository priorityRepository;

    @Override
    public Iterable<Priority> getALl() {
        return priorityRepository.findAll();
    }

    @Override
    public Optional<Priority> getById(Short id) {
        return priorityRepository.findById(id);
    }
}
