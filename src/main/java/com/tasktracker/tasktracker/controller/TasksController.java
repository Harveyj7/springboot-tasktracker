package com.tasktracker.tasktracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasktracker.tasktracker.entity.Tasks;
import com.tasktracker.tasktracker.repository.TasksRepository;
import com.tasktracker.tasktracker.dto.TaskCreationDto;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    private final TasksRepository tasksRepository;

    public TasksController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Tasks> createTask(@RequestBody TaskCreationDto taskCreationDto) {
        Tasks task = new Tasks();
        task.setTitle(taskCreationDto.getTitle());
        task.setDescription(taskCreationDto.getDescription());
        task.setStatus(taskCreationDto.getStatus());
        task.setDueDate(taskCreationDto.getDueDate());

        Tasks savedTask = tasksRepository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> tasks = tasksRepository.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
