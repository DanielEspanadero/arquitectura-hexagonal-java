package com.exagonal.tasks.domain.ports.in;

import com.exagonal.tasks.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
}
