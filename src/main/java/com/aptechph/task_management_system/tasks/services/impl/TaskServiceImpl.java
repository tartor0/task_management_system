package com.aptechph.task_management_system.tasks.services.impl;

import com.aptechph.task_management_system.common.exception.ResourceNotFoundException;
import com.aptechph.task_management_system.tasks.dto.TaskRequestDto;
import com.aptechph.task_management_system.tasks.dto.TaskResponseDto;
import com.aptechph.task_management_system.tasks.mapper.TaskMapper;
import com.aptechph.task_management_system.tasks.model.Task;
import com.aptechph.task_management_system.tasks.repository.TaskRepository;
import com.aptechph.task_management_system.tasks.services.TaskService;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional

public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }


    @Override
    public TaskResponseDto createTask(TaskRequestDto request) {
        Task entity = taskMapper.toEntity(request);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        Task saved = taskRepository.save(entity);
        return taskMapper.toDto(saved);
    }


    @Override
    public TaskResponseDto getTaskById(Long id) {
        Task t = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        return taskMapper.toDto(t);
    }


    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll().stream().map(taskMapper::toDto).toList();
    }


    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto request) {
        Task t = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        t.setTitle(request.getTitle());
        t.setDescription(request.getDescription());
        t.setAssigneeId(request.getAssigneeId());
        t.setStatus(request.getStatus());
        t.setPriority(request.getPriority());
        t.setDueDate(request.getDueDate());
        t.setUpdatedAt(LocalDateTime.now());
        Task updated = taskRepository.save(t);
        return taskMapper.toDto(updated);
    }


    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);}

}
