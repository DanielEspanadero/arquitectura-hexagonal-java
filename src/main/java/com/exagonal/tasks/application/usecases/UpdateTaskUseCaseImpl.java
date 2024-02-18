package com.exagonal.tasks.application.usecases;

import com.exagonal.tasks.domain.model.Task;
import com.exagonal.tasks.domain.ports.in.UpdateTaskUseCase;
import com.exagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepositoryPort.update(updatedTask);
    }
}
