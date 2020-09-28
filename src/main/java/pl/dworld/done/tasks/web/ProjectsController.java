package pl.dworld.done.tasks.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dworld.done.tasks.application.TasksService;
import pl.dworld.done.tasks.domain.Task;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/projects")
@AllArgsConstructor
class ProjectsController {
    private final TasksService tasksService;

    @GetMapping("/inbox")
    public List<Task> getInbox() {
        return tasksService.getInbox();
    }

    @GetMapping("/priority")
    public List<Task> getPriority() {
        return tasksService.getPriority();
    }

}
