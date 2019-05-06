package com.netcracker.projectmanager.services;

import com.netcracker.projectmanager.models.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TaskDataService {
    List<Task> getAll();
    List<Task> getTasksByProjectId(Integer projectId);
    Task getTasksById(Integer id);
    Task saveTask(Task task);
    Task uploadAttachments(MultipartFile file, Long id);
    void deleteTaskById(Integer id);

    List<Task> getAllPageable(int page, int size, String property, Sort.Direction direction);
}
