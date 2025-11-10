package com.aptechph.task_management_system.users.services;

import com.aptechph.task_management_system.users.dto.UserRequest;
import com.aptechph.task_management_system.users.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    UserResponse getUserById(long id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(long id, UserRequest request);
    void deleteUser(long id);
}
