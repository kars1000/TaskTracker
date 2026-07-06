package com.tasktracker.resouce;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.tasktracker.dto.TaskContainerDTO;
import com.tasktracker.dto.TaskDTO;
import com.tasktracker.entity.Task;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TasksResourceIntegrationTest {

	@Autowired
	private RestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void createTask() {
		TaskContainerDTO test = restTemplate.postForEntity("http://localhost:" + port + "/tasks",
				new TaskDTO(new Task("testing")), TaskContainerDTO.class).getBody();

		assertThat(test.getTask().getTaskDescription()).isEqualTo("testing");
	}

	@Test
	public void getTasks() {
		String test = restTemplate.getForEntity("http://localhost:" + port + "/tasks", String.class).getBody();

		System.out.println(test);
	}

	@Test
	public void updateTasks() {
		restTemplate.put("http://localhost:" + port + "/tasks/10", null);

	}

}
