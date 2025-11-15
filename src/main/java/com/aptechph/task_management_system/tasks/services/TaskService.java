package com.aptechph.task_management_system.tasks.services;

import com.aptechph.task_management_system.tasks.dto.TaskRequestDto;
import com.aptechph.task_management_system.tasks.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    TaskResponseDto createTask(TaskRequestDto request);
    TaskResponseDto getTaskById(Long id);
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto updateTask(Long id, TaskRequestDto request);
    void deleteTask(Long id);

}
