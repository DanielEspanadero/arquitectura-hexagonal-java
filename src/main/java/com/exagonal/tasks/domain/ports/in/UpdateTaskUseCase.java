package com.exagonal.tasks.domain.ports.in;

import com.exagonal.tasks.domain.model.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updatedTask);
}
