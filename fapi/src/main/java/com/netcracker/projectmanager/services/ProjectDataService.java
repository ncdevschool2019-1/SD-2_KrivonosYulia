package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.Project;

import java.util.List;

public interface ProjectDataService {
    List<Project> getAll();
    Project getById(Integer id);
    Project save(Project project);
    void delete(Integer id);

}
