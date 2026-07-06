package com.tasktracker.repository;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tasktracker.entity.Task;

@SpringBootTest
public class TaskRepositoryIntegrationTest {

	@Autowired
	private TaskRepository taskRepository;

	@Test
	public void testOptimisticLockException() {
		
		Task task = new Task("testing");
		
		task = taskRepository.saveAndFlush(task);
		
		Task a = taskRepository.findById(task.getId()).get();
		a.setTaskDescription("testing");
		
		Task b = taskRepository.findById(task.getId()).get();
		b.setTaskDescription("another test");
		
		
		
		taskRepository.saveAndFlush(b);
		
		try {
			taskRepository.saveAndFlush(a);
			fail("should never reach this block of code");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		taskRepository.findAll().forEach(e -> System.out.println(e.getId()));
		
	}

}
