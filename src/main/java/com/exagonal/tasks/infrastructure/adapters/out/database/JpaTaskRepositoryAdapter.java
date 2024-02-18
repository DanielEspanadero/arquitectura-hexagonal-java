package com.exagonal.tasks.infrastructure.adapters.out.database;

import com.exagonal.tasks.domain.model.Task;
import com.exagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.exagonal.tasks.infrastructure.entities.EntityId;
import com.exagonal.tasks.infrastructure.entities.TaskEntity;
import com.exagonal.tasks.infrastructure.mappers.TaskMapper;
import com.exagonal.tasks.infrastructure.repositories.JpaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = taskMapper.mapAsTaskEntity(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return taskMapper.mapAsTask(savedTaskEntity);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(EntityId.of(id)).map(taskMapper::mapAsTask);
    }

    @Override
    public List<Task> findAll() {
        List<TaskEntity> all = jpaTaskRepository.findAll();
        return taskMapper.mapAsTaskList(all);
    }

    @Override
    public Optional<Task> update(Task task) {
        if (jpaTaskRepository.existsById(EntityId.of(task.getId()))) {
            TaskEntity taskEntity = taskMapper.mapAsTaskEntity(task);
            TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(taskMapper.mapAsTask(updatedTaskEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaTaskRepository.existsById(EntityId.of(id))) {
            jpaTaskRepository.deleteById(EntityId.of(id));
            return true;
        }
        return false;
    }
}
