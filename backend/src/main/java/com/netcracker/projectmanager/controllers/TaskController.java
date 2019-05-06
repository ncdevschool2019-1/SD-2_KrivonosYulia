package com.netcracker.projectmanager.controllers;


import com.netcracker.projectmanager.entity.Attachment;
import com.netcracker.projectmanager.entity.Project;
import com.netcracker.projectmanager.entity.Task;
import com.netcracker.projectmanager.services.FileService;
import com.netcracker.projectmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Value("${upload.path.task}")
    private String uploadPath;


    private TaskService taskService;
    private FileService fileService;
    @Autowired
    public TaskController(TaskService taskService, FileService fileService) {
        this.taskService = taskService;
        this.fileService = fileService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskById(@PathVariable(name = "id") Integer id) {
        Task task = taskService.findById(id);
        if (task!= null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseEntity<Page<Task>> getAllPageable(@RequestParam("page") int page,
                                                        @RequestParam("size") int size,
                                                        @RequestParam("sort") String property,
                                                        @RequestParam("direction") Sort.Direction direction) {
        Pageable pageable =PageRequest.of(page, size, direction, property);
        return ResponseEntity.ok(taskService.findPaginated(pageable));
    }
//
//    @RequestMapping(value = "/page/project/{projectId}")
//    public ResponseEntity<Page<Task>> getByProjectPage(@PathVariable (value = "projectId") Integer projectId,
//                                       Pageable pageable){
//        return ResponseEntity.ok(taskService.findByProjectCodePaginated(projectId, pageable));
//
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }


    @RequestMapping(value = "/projects/{projectCode}",method = RequestMethod.GET)
    public ResponseEntity<Page<Task>> getTasksByProjectCodePageable(@PathVariable(name = "projectCode") Integer projectCode,
                                                                    @RequestParam("page") int page,
                                                                    @RequestParam("size") int size,
                                                                    @RequestParam("sort") String property,
                                                                    @RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction) {
        Pageable pageable =PageRequest.of(page, size, direction, property);
        return ResponseEntity.ok(taskService.findByProjectCodePaginated(projectCode, pageable));
    }

    @RequestMapping(value = "/project/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(taskService.findByProjectId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> saveTask(@RequestBody Task task) throws Exception {
        return ResponseEntity.ok(taskService.save(task));
    }


    @RequestMapping(value = "file/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Task> saveAttachments(@PathVariable("id") Integer taskId,
                                         @RequestParam("files") MultipartFile[] files) throws Exception {
        return ResponseEntity.ok(taskService.saveAttachments(files,taskId));
    }

    @RequestMapping(value = "/file/{fileName:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
        org.springframework.core.io.Resource file = null;
        try {
            file = this.fileService.getFile(fileName);
            if(!file.isReadable()){
                file = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(file);
    }

//    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
//    public ResponseEntity saveFile(@RequestParam("files") MultipartFile[] files){
//        if(files!=null){
//          Set<Attachment> attachments = new HashSet<>();
//          for (MultipartFile file: files) {
//              Attachment at = new Attachment();
//              at.setTask(task);
//              at.setDocument(fileService.uploadFile(file,uploadPath));
//              attachments.add(at);
//          }
//          task.setAttachments(attachments);
//      }
//    }




    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable(name = "id") Integer id) {
        taskService.delete(id);
       return ResponseEntity.ok().build();
    }

}
