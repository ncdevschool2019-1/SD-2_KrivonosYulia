package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.entity.Attachment;
import com.netcracker.projectmanager.entity.Task;

import java.util.List;

public interface AttachmentService {
    List<Attachment> getAll();
    List<Attachment> getByTask(Integer taskId);
    Attachment getById(Long id);


}
