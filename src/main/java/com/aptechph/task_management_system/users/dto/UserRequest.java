package com.aptechph.task_management_system.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "username is required")
    private String username;
    @Email(message = "email must be valid")
    private String email;
    private String fullName;
}
