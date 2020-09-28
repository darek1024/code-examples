package pl.dworld.done.tasks.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.dworld.done.tasks.application.ProjectsService;
import pl.dworld.done.tasks.application.TasksService;
import pl.dworld.done.tasks.domain.Project;
import pl.dworld.done.tasks.domain.Task;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/projects")
@AllArgsConstructor
class ProjectsController {
    private final TasksService tasksService;
    private final ProjectsService projectsService;

    @GetMapping("/inbox")
    public List<Task> getInbox() {
        return tasksService.getInbox();
    }

    @GetMapping("/priority")
    public List<Task> getPriority() {
        return tasksService.getPriority();
    }

    @PostMapping
    public Project addProject(@RequestParam String name) {
        return projectsService.addProjects(name);
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return projectsService.getById(id);
    }

}
