package com.aptechph.task_management_system.tasks.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskRequestDto {
    @NotBlank(message = "title is required")
    private String title;
    private String description;
    private Long assigneeId;
    private String status; // OPEN, IN_PROGRESS, DONE
    private String priority; // LOW, MEDIUM, HIGH
    private LocalDateTime dueDate;
}
