package com.tasktracker.tasktracker.controller;

import com.tasktracker.tasktracker.dto.TaskCreationDto;
import com.tasktracker.tasktracker.entity.Tasks;
import com.tasktracker.tasktracker.service.TasksService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    /**
     * GET /api/tasks - Get all tasks
     */
    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    /**
     * GET /api/tasks/:id - Get a specific task
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTask(@PathVariable Long id) {
        return tasksService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/tasks - Create a new task
     */
    @PostMapping
    public ResponseEntity<Tasks> createTask(@Valid @RequestBody TaskCreationDto taskCreationDto) {
        Tasks createdTask = tasksService.createTask(taskCreationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    /**
     * PUT /api/tasks/:id - Update a task
     */
    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable Long id, @Valid @RequestBody TaskCreationDto taskCreationDto) {
        return tasksService.updateTask(id, taskCreationDto)
                .map(updatedTask -> ResponseEntity.ok(updatedTask))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/tasks/:id - Delete a task
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        boolean deleted = tasksService.deleteTask(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
