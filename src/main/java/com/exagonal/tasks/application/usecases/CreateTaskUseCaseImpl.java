package com.exagonal.tasks.application.usecases;

import com.exagonal.tasks.domain.model.Task;
import com.exagonal.tasks.domain.ports.in.CreateTaskUseCase;
import com.exagonal.tasks.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
