package com.netcracker.projectmanager.repositories;

import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.entity.Task;
import com.netcracker.projectmanager.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByReporter(User user);
    List<Task> findByAssignedUser(User user);
    List<Task> findByProjectCode(Project project);

//    Page<Task> findAll(Project projectCode, Pageable pageable);
    Page<Task> findByProjectCode(Project projectCode, Pageable pageable);
}
