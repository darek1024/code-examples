package pl.dworld.done.tasks.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dworld.done.tasks.application.TasksService;
import pl.dworld.done.tasks.domain.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
class TasksController {
    private final TasksService tasksService;

    @GetMapping
    public List<Task> getTasks() {
        return tasksService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody CreateTaskCommand command) {
        tasksService.addTask(command.title, command.dueDate);
    }

    @Data
    static class CreateTaskCommand {
        String title;
        LocalDate dueDate;
    }

}
