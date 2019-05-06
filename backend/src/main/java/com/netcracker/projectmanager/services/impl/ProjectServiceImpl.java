package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.repositories.ProjectReposirory;
import com.netcracker.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectReposirory projectReposirory;

    @Override
    public List<Project> findAll() {
        return projectReposirory.findAll();
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return projectReposirory.findAll(pageable);
    }

    @Override
    public Page<Project> findAllByProjectCodeLike(String projectCode, Pageable pageable) {
        return projectReposirory.findAllByProjectCodeLike(projectCode, pageable);
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
       return projectReposirory.save(project);
    }

    @Override
    public void delete(Integer id) {
        projectReposirory.delete(findById(id));
    }
}
