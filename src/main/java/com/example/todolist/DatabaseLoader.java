package com.example.todolist;

import com.example.todolist.domain.Task;
import com.example.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final TaskRepository repo;

    @Autowired
    public DatabaseLoader(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... strings) throws Exception{
        this.repo.save(new Task("Feed dog", "Give fido some food", new Date()));
        System.out.println("added thing to database");
    }
}
