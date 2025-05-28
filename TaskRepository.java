package com.taskmanagementsystem.taskmanagementsystem.repository;

import com.taskmanagementsystem.taskmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}