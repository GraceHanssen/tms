package com.taskmanagementsystem.taskmanagementsystem.controller;

import com.taskmanagementsystem.taskmanagementsystem.model.Task;
import com.taskmanagementsystem.taskmanagementsystem.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("task", new Task());
        return "createForm";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "createForm";
        }
        taskService.saveTask(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "editTask";
    }

    @RequestMapping(value = "/updateTask", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateTask(@RequestParam("id") Long id, @ModelAttribute("task") Task updatedTask, RedirectAttributes redirectAttributes) {
        Task task = taskService.getTaskById(id);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        taskService.updateTask(task);
        redirectAttributes.addFlashAttribute("msg", "Task updated successfully.");
        return "redirect:/";
    }

    @PostMapping("/deleteTask")
    public String delete(@RequestParam("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/";
    }

}