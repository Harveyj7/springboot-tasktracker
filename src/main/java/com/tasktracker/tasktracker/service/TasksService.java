package com.tasktracker.tasktracker.service;

import com.tasktracker.tasktracker.dto.TaskCreationDto;
import com.tasktracker.tasktracker.entity.Tasks;
import com.tasktracker.tasktracker.repository.TasksRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TasksService {

    private final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    /**
     * Get all tasks
     * @return List of all tasks
     */
    @Transactional(readOnly = true)
    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    /**
     * Get a specific task by ID
     * @param id The task ID
     * @return Optional containing the task if found
     */
    @Transactional(readOnly = true)
    public Optional<Tasks> getTaskById(Long id) {
        return tasksRepository.findById(id);
    }

    /**
     * Create a new task
     * @param taskCreationDto The task creation data
     * @return The created task
     */
    public Tasks createTask(TaskCreationDto taskCreationDto) {
        Tasks task = new Tasks();
        task.setTitle(taskCreationDto.getTitle());
        task.setDescription(taskCreationDto.getDescription());
        task.setStatus(taskCreationDto.getStatus());
        task.setDueDate(taskCreationDto.getDueDate());
        
        return tasksRepository.save(task);
    }

    /**
     * Update an existing task
     * @param id The task ID to update
     * @param taskCreationDto The updated task data
     * @return Optional containing the updated task if found
     */
    public Optional<Tasks> updateTask(Long id, TaskCreationDto taskCreationDto) {
        return tasksRepository.findById(id)
                .map(existingTask -> {
                    if (taskCreationDto.getTitle() != null) {
                        existingTask.setTitle(taskCreationDto.getTitle());
                    }
                    if (taskCreationDto.getDescription() != null) {
                        existingTask.setDescription(taskCreationDto.getDescription());
                    }
                    if (taskCreationDto.getStatus() != null) {
                        existingTask.setStatus(taskCreationDto.getStatus());
                    }
                    if (taskCreationDto.getDueDate() != null) {
                        existingTask.setDueDate(taskCreationDto.getDueDate());
                    }
                    return tasksRepository.save(existingTask);
                });
    }

    /**
     * Delete a task by ID
     * @param id The task ID to delete
     * @return true if task was deleted, false if not found
     */
    public boolean deleteTask(Long id) {
        if (tasksRepository.existsById(id)) {
            tasksRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 