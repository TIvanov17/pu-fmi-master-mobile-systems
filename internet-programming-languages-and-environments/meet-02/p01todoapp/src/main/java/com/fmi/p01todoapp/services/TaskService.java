package com.fmi.p01todoapp.services;

import com.fmi.p01todoapp.models.TaskInputDTO;
import com.fmi.p01todoapp.models.enums.Status;
import com.fmi.p01todoapp.models.Task;
import java.util.List;

public interface TaskService {

  Task createTask(TaskInputDTO taskInputDTO);

  Task updateTask(Long id, Status status);

  Task getTaskById(Long id);

  List<Task> getTasks();

  void deleteTask(Long id);

}
