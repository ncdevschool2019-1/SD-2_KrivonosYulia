package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.Attachment;
import com.netcracker.projectmanager.entity.Task;
import com.netcracker.projectmanager.repositories.AttachmentsRepository;
import com.netcracker.projectmanager.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {

   @Autowired
   private AttachmentsRepository attachmentsRepository;

    @Override
    public List<Attachment> getAll() {
        return (List<Attachment>) attachmentsRepository.findAll();
    }

    @Override
    public List<Attachment> getByTask(Integer taskId) {
        return attachmentsRepository.findByTask(taskId);
    }

    @Override
    public Attachment getById(Long id) throws NullPointerException{
       Optional<Attachment> attachment = attachmentsRepository.findById(id);
        return attachment.orElse(null);
    }
}
