package com.aptechph.task_management_system.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(String anUnexpectedErrorOccurred, LocalDateTime now) {
    }
}