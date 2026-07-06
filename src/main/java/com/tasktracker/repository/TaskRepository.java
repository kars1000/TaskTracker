package com.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasktracker.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>  {

}
