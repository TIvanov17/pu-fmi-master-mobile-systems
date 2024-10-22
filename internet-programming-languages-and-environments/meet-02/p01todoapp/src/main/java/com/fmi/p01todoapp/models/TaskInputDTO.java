package com.fmi.p01todoapp.models;

import com.fmi.p01todoapp.models.enums.Status;
import java.time.LocalDateTime;
import java.util.Date;

public class TaskInputDTO {

  private String title;

  private String description;

  private Status status;

  private Date dueDate;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }
}
