package com.netcracker.projectmanager.repositories;

import com.netcracker.projectmanager.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectReposirory extends CrudRepository<Project,Integer> {
    Optional<Project> findByProjectCode(String projectCode);
}
