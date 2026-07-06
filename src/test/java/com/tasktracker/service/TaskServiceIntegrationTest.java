package com.tasktracker.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tasktracker.dto.TaskDTO;
import com.tasktracker.entity.Task;

@SpringBootTest
public class TaskServiceIntegrationTest {
	
	@Autowired
	TaskService taskTrackerService;
	
	@Test
	public void createTask() {
		
		Task task = new Task("testing");
		taskTrackerService.createTask(new TaskDTO(task));
	}
	
	@Test
	public void updateTask() {
		
	}

}
