package com.netcracker.projectmanager.repositories;

import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.entity.Task;
import com.netcracker.projectmanager.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

    List<Task> findByReporter(User user);
    List<Task> findByAssignedUser(User user);
    List<Task> findByProjectCode(Project project);

}
