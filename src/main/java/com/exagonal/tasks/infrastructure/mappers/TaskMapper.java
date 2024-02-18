package com.exagonal.tasks.infrastructure.mappers;

import com.exagonal.tasks.domain.model.Task;
import com.exagonal.tasks.infrastructure.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Mapping(target = "id.value", source = "id")
    TaskEntity mapAsTaskEntity(Task task);

    @Mapping(source = "id.value", target = "id")
    Task mapAsTask(TaskEntity taskEntity);

    List<Task> mapAsTaskList(List<TaskEntity> taskEntityList);
}
