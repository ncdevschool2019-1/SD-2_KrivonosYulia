package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.repositories.ProjectReposirory;
import com.netcracker.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectReposirory projectReposirory;

    @Override
    public Iterable<Project> findAll() {
        return projectReposirory.findAll();
    }

    @Override
    public Project findById(Integer id) {
        return projectReposirory.findById(id).isPresent()? projectReposirory.findById(id).get(): null ;
    }

    @Override
    public Project findByProjectCode(String projectCode) {
        return projectReposirory.findByProjectCode(projectCode).isPresent()? projectReposirory.findByProjectCode(projectCode).get(): null ;
    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        projectReposirory.delete(findById(id));
    }
}
