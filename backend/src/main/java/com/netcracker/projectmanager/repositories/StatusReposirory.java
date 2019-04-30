package com.netcracker.projectmanager.repositories;

import com.netcracker.projectmanager.entity.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusReposirory extends CrudRepository<Status,Short> {
}
