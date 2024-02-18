package com.exagonal.tasks.application.usecases;

import com.exagonal.tasks.domain.model.Task;
import com.exagonal.tasks.domain.ports.in.CreateTaskUseCase;
import com.exagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
