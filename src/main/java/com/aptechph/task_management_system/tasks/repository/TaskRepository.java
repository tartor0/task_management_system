package com.aptechph.task_management_system.tasks.repository;

import com.aptechph.task_management_system.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Long> {
}
