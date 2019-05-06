package com.netcracker.projectmanager.controllers;


import com.netcracker.projectmanager.models.Task;
import com.netcracker.projectmanager.services.ConverterDataService;
import com.netcracker.projectmanager.services.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskDataController {

    @Autowired
    private TaskDataService taskDataService;

    @Autowired
    private ConverterDataService converterDataService;

    @RequestMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> task = taskDataService.getAll();
        return ResponseEntity.ok(task);

    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllPageable(@RequestParam("page") int page,
                                                     @RequestParam("size") int size,
                                                     @RequestParam("sort") String properties,
                                                     @RequestParam("direction") Sort.Direction direction) {
        List<Task> tasks = taskDataService.getAllPageable(page, size, properties, direction);
        return tasks!=null? ResponseEntity.ok(tasks) :  ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getByProjectIdPageable(@PathVariable("projectId") Integer projectId,
                                                             @RequestParam("page") int page,
                                                             @RequestParam("size") int size,
                                                             @RequestParam("sort") String properties,
                                                             @RequestParam("direction") Sort.Direction direction) {
        List<Task> tasks = taskDataService.getAllPageable(page, size, properties, direction);
        return tasks!=null? ResponseEntity.ok(tasks) :  ResponseEntity.badRequest().build();
    }


    @RequestMapping(value = "/project/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable(name = "id") Integer id){
        List<Task> task = taskDataService.getTasksByProjectId(id);
        return ResponseEntity.ok(task);
    }

//    @RequestMapping(value = "/image/{imageName:.+}", method = RequestMethod.GET)
//    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
//
//        try {
//            Resource image = this.taskDataService.getFile(imageName);
//            if (image.exists() || image.isReadable()) {
//                return ResponseEntity.ok(image);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.notFound().build();
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Task> saveTask(@RequestBody Task task,
//                                         MultipartHttpServletRequest request ){
//        if(task != null){
//            Iterator<String> itr = request.getFileNames();
//            ArrayList<MultipartFile>  arrayList= new ArrayList<>();
//            while (itr.hasNext()){
//                arrayList.add(request.getFile(itr.next()));
//            }
//
//            request.getFile(itr.next());
//            return ResponseEntity.ok(taskDataService.saveTask(task, arrayList));
//        }
//        return ResponseEntity.badRequest().build();
//    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> saveTask(@RequestBody Task task
    ){
        if(task != null){
            return ResponseEntity.ok(taskDataService.saveTask(task));
        }
        return ResponseEntity.badRequest().build();
    }


    @RequestMapping(value = "/image/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Task> saveAttachments(MultipartHttpServletRequest request,
                                                @PathVariable(name = "id") Long id){
        Iterator<String> itr = request.getFileNames();
        Task task = this.taskDataService.uploadAttachments(request.getFile(itr.next()), id);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable Integer id){
        taskDataService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id){
        Task task = taskDataService.getTasksById(id);
        return task!=null? ResponseEntity.ok(task): ResponseEntity.ok().build();
    }



}
