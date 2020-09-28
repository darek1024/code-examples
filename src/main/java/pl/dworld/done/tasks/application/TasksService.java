package pl.dworld.done.tasks.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dworld.done.tasks.db.TasksJpaRepository;
import pl.dworld.done.tasks.domain.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TasksService {
    private final TasksJpaRepository repository;

    public List<Task> getAll() {
        return repository.findAll();
    }

    public List<Task> getPriority() {
        LocalDate now = LocalDate.now();
        return repository.findByPriorityIsTrueOrDueDateLessThanEqual(now);
    }

    public List<Task> getInbox() {
        // TODO-Darek: todo
        return repository.findAll();
    }

    public void addTask(String title, LocalDate dueDate) {
        Task task = new Task(title, dueDate);
        repository.save(task);
    }
}
