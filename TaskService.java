package com.taskmanagementsystem.taskmanagementsystem.service;

import com.taskmanagementsystem.taskmanagementsystem.model.Task;
import com.taskmanagementsystem.taskmanagementsystem.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List getAllTasks() {
        return taskRepository.findAll();
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        } else {
            throw new RuntimeException("Task with id " + id + " not found.");
        }
    }
}