package com.example.todolist.domain;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@RestResource(rel = "tasks", path = "tasks")
@Table(name="Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String taskDescription;
    private Date taskDueDate;

    public Task() {}

    public Task(String taskName, String taskDescription, Date taskDueDate) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
    }
}
