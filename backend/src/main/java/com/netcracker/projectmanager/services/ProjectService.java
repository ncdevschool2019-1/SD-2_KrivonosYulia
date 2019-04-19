package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.entity.Project;

public interface ProjectService {
    Iterable<Project> findAll();
    Project findById(Integer id);
    Project findByProjectCode(String projectCode);


    Project save(Project project);
    void delete(Integer id);
}
