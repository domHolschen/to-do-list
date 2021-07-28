package com.example.todolist.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO {
    String taskName;
    String taskDescription;
    Date taskDueDate;

    public Task convertToTask() {
        Task task = new Task();
        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
        task.setTaskDueDate(taskDueDate);
        return task;
    }
}
