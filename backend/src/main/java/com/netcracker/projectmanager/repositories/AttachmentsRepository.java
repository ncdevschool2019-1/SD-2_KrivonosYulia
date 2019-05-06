package com.netcracker.projectmanager.repositories;

import com.netcracker.projectmanager.entity.Attachment;
import com.netcracker.projectmanager.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentsRepository extends CrudRepository<Attachment, Long> {

    List<Attachment> findByTask(Integer taskId);
}
