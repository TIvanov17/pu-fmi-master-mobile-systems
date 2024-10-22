package com.fmi.p01todoapp.services;

import com.fmi.p01todoapp.models.TaskInputDTO;
import com.fmi.p01todoapp.models.enums.Status;
import com.fmi.p01todoapp.models.Task;
import com.fmi.p01todoapp.repositories.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired private TaskRepository taskRepository;

  @Override
  public Task createTask(TaskInputDTO taskInputDTO) {

    Task task = new Task();
    task.setTitle(taskInputDTO.getTitle());
    task.setDescription(taskInputDTO.getDescription());
    task.setDueDate(taskInputDTO.getDueDate());
    task.setStatus(taskInputDTO.getStatus());

    return taskRepository.saveTask(task);
  }

  @Override
  public Task updateTask(Long id, Status status) {
    Task task = getTaskById(id);
    task.setStatus(status);
    return task;
  }

  @Override
  public Task getTaskById(Long id) {
    return taskRepository.findTaskById(id);
  }

  @Override
  public List<Task> getTasks() {
    return taskRepository.findTasks();
  }

  @Override
  public void deleteTask(Long id) {
    taskRepository.deleteTask(id);
  }

}
