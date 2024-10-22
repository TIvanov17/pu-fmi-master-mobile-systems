package com.fmi.p01todoapp.controllers;

import com.fmi.p01todoapp.models.enums.Status;
import com.fmi.p01todoapp.models.Task;
import com.fmi.p01todoapp.models.TaskInputDTO;
import com.fmi.p01todoapp.models.enums.TaskUpdateDTO;
import com.fmi.p01todoapp.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskApi {

  @Autowired private TaskService taskService;

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody TaskInputDTO taskInputDTO){
    return ResponseEntity.ok(taskService.createTask(taskInputDTO));
  }

  @GetMapping
  public ResponseEntity<List<Task>> getTasks(){
    return ResponseEntity.ok(taskService.getTasks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Task> getTask(@PathVariable Long id){
    return ResponseEntity.ok(taskService.getTaskById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskUpdateDTO taskUpdateDTO){
    return ResponseEntity.ok(taskService.updateTask(id, taskUpdateDTO.getStatus()));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTask(@PathVariable Long id){
    taskService.deleteTask(id);
    return ResponseEntity.noContent().build();
  }

}
