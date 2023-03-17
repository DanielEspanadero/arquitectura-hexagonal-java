package com.exagonal.tasks.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
