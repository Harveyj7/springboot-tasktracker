package com.tasktracker.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tasktracker.tasktracker.entity.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    // Basic CRUD operations are automatically provided by JpaRepository
    
    // Custom query methods can be added here as needed
    // For example:
    // List<Tasks> findByStatus(String status);
    // List<Tasks> findByDueDateBefore(LocalDate date);
    // List<Tasks> findByTitleContainingIgnoreCase(String title);
}
