package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProjectDataService {
    List<Project> getAll();
    List<Project> getAll(int page, int size, Sort.Direction direction, String properties);
    Page<Project> getAllByPartProjectCode(String projectCode, Pageable pageable);
    Project getById(Integer id);
    Project save(Project project);
    void delete(Integer id);

}
