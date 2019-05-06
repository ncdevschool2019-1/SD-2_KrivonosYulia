package com.netcracker.projectmanager.services.impl;

import com.netcracker.projectmanager.entity.Attachment;
import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.entity.Task;
import com.netcracker.projectmanager.entity.User;
import com.netcracker.projectmanager.repositories.TaskRepository;
import com.netcracker.projectmanager.services.FileService;
import com.netcracker.projectmanager.services.ProjectService;
import com.netcracker.projectmanager.services.TaskService;
import com.netcracker.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Table;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskServiceImpl implements  TaskService {

    @Value("${upload.path.task}")
    private String uploadPath;

    @Autowired
    public TaskServiceImpl(FileService fileService,TaskRepository taskRepository,
                           ProjectService projectService,UserService userService) {
        this.taskRepository =taskRepository;
        this.fileService = fileService;
        this.projectService = projectService;
        this.userService = userService;
    }

    private FileService fileService;

    private TaskRepository taskRepository;

    private UserService userService;

    private ProjectService projectService;


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public List<Task> findByUserReporter(String email) {
        User user = userService.findByEmail(email);
        if(user != null){
            return taskRepository.findByReporter(user);
        }
        else {
            throw new RuntimeException("Invalid email. User with such email is not exist");
        }
    }

    @Override
    public List<Task> findByUserAssigned(String email) {

        User user = userService.findByEmail(email);
        if(user != null){
            return taskRepository.findByAssignedUser(user);
        }
        else {
            throw new RuntimeException("Invalid email. User with such email is not exist");
        }
    }

    @Override
    public List<Task> findByProjectCode(String projectCode) {
        Project project = projectService.findByProjectCode(projectCode);
        if(project!= null){
            return taskRepository.findByProjectCode(project);
        }
       else {
           return null;
        }
    }

    @Override
    public Page<Task> findPaginated(Pageable pageable){
        return taskRepository.findAll(pageable);
    }



    @Override
    public Page<Task> findByProjectCodePaginated(Integer projectId, Pageable pageable) {
        Project project = projectService.findById(projectId);
        return taskRepository.findByProjectCode(project, pageable);
    }


    @Override
    public List<Task> findByProjectId(Integer projectId) {
        Project project = projectService.findById(projectId);
        if(project!= null){
            return taskRepository.findByProjectCode(project);
        }
        else {
            return null;
        }
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }


    @Override
    public Task saveAttachments(MultipartFile[] files, Integer taskId) {
        Set<Attachment> attachments = new HashSet<>();
        Task task = findById(taskId);
        for (MultipartFile file : files) {
            Attachment attachment = new Attachment();
            try {
                attachment.setDocument(fileService.uploadFile(file,uploadPath));
                attachment.setTask(task);
            } catch (Exception e) {
                e.printStackTrace();
            }
            attachments.add(attachment);
        }
        task.setAttachments(attachments);
       return save(task);
    }

    @Override
    public void delete(Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(task1 -> taskRepository.delete(task1));
//        if(task.isPresent()){
//            String filename;
//            Set<Attachment> attachmentSet = task.get().getAttachments();
//            if (!attachmentSet.isEmpty()){
//                for (Attachment doc: attachmentSet) {
//                    filename = new String(uploadPath + File.separator +doc.getDocument());
//                    fileService.deleteFile(filename);
//                }
//            }
//            taskRepository.delete(task.get());
//        }
    }
}
