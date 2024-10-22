package com.fmi.p01todoapp.repositories;

import com.fmi.p01todoapp.models.Task;
import com.fmi.p01todoapp.services.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

  private static final List<Task> tasks = new ArrayList<>();

  @Autowired private SequenceGenerator sequenceGenerator;

  @Override
  public Task saveTask(Task task) {
    task.setId(sequenceGenerator.getNextId());
    tasks.add(task);
    return task;
  }

  @Override
  public Task findTaskById(Long id) {
    return tasks.stream()
        .filter(task -> task.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<Task> findTasks() {
    return tasks;
  }

  @Override
  public void deleteTask(Long id) {
    Task task = findTaskById(id);
    tasks.remove(task);
  }
}
