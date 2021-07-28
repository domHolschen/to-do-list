package com.example.todolist.web;

import com.example.todolist.domain.Task;
import com.example.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/tasks", produces = "application/json")
public class HomeController {
    private TaskRepository taskRepository;

    @Autowired
    public HomeController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    private EntityModel<Task> getTaskById(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return EntityModel.of(
                task,
                linkTo(methodOn(HomeController.class).getTaskById(id)).withSelfRel(),
                linkTo(methodOn(HomeController.class).allTasks()).withRel("app")
        );
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    @ResponseBody
    public void deleteTaskById(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @GetMapping//(path = "/tasks")
    @ResponseBody
    public Iterable<Task> allTasks() {return taskRepository.findAll();}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Task postNewTask(@RequestBody Task task) {
        taskRepository.save(task);
        return task;
    }
}
