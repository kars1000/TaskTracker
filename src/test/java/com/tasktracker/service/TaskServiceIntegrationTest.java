package com.tasktracker.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tasktracker.dto.TaskContainerDTO;
import com.tasktracker.dto.TaskDTO;
import com.tasktracker.entity.Task;
import com.tasktracker.repository.TaskRepository;

@SpringBootTest
public class TaskServiceIntegrationTest {
	
	@BeforeEach 
    void init() {
		taskRepository.deleteAll();
    }
	
	@Autowired
	TaskService taskTrackerService;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Test
	public void createTask() {
		
		Task task = new Task("testing");
		taskTrackerService.createTask(new TaskDTO(task));
	}
	
	@Test
	public void updateTask() {
		Task task = new Task("testing");
		TaskContainerDTO container = taskTrackerService.createTask(new TaskDTO(task));
		
		taskTrackerService.updateTask(container.getTask().getId(), new TaskDTO("new description"));
	}
	
	@Test
	public void findAllTasks() {
		Task task = new Task("testing");
		TaskContainerDTO container = taskTrackerService.createTask(new TaskDTO(task));
		
		container = taskTrackerService.findAllTasks();
		
		assertThat(container.getTasks().size()).isEqualTo(1);
	}

}
