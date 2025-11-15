package com.aptechph.task_management_system.tasks.mapper;

import com.aptechph.task_management_system.tasks.dto.TaskRequestDto;
import com.aptechph.task_management_system.tasks.dto.TaskResponseDto;
import com.aptechph.task_management_system.tasks.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskRequestDto dto);
    TaskResponseDto toDto(Task entity);
}
