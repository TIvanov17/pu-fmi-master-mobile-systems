package com.fmi.p01todoapp.repositories;

import com.fmi.p01todoapp.models.Task;
import java.util.List;

public interface TaskRepository {

  Task saveTask(Task task);

  Task findTaskById(Long id);

  List<Task> findTasks();

  void deleteTask(Long id);

}
