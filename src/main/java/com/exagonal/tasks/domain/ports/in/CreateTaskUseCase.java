package com.exagonal.tasks.domain.ports.in;

import com.exagonal.tasks.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
