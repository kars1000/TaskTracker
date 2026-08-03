package com.tasktracker.resouce;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tasktracker.dto.TaskContainerDTO;
import com.tasktracker.dto.TaskDTO;
import com.tasktracker.entity.Task;
import com.tasktracker.repository.TaskRepository;
import com.tasktracker.service.TaskService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TasksResourceIntegrationTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	TaskService taskService;

	@LocalServerPort
	private int port;

	@Autowired
	TaskRepository taskRepository;

	@BeforeEach
	void init() {
		taskRepository.deleteAll();
	}

	@Test
	public void createTask() {

		ResponseEntity<TaskContainerDTO> entity = restTemplate.postForEntity("http://localhost:" + port + "/tasks",
				new TaskDTO(new Task("testing")), TaskContainerDTO.class);
		TaskContainerDTO test = entity.getBody();

		assertThat(entity.getStatusCode().value()).isEqualTo(200);

		assertThat(test.getTask().getTaskDescription()).isEqualTo("testing");
	}

	@Test
	public void getTasks() {

		createTask();
		TaskContainerDTO container = restTemplate
				.getForEntity("http://localhost:" + port + "/tasks", TaskContainerDTO.class).getBody();

		assertThat(container.getTasks().size()).isEqualTo(1);
	}

	@Test
	public void updateTasks() {
		TaskContainerDTO taskContainer = taskService.createTask(new TaskDTO("testing"));
		long id = taskContainer.getTask().getId();
		String taskDescription = "testing new description";
		restTemplate.put("http://localhost:" + port + "/tasks/" + id, new TaskDTO(new Task(taskDescription)));

		assertThat(taskRepository.findById(id).get().getTaskDescription()).isEqualTo(taskDescription);
	}

	@Test
	public void deleteTask() {
		ResponseEntity<TaskContainerDTO> entity = restTemplate.postForEntity("http://localhost:" + port + "/tasks",
				new TaskDTO(new Task("testing")), TaskContainerDTO.class);
		TaskContainerDTO test = entity.getBody();
		restTemplate.delete("http://localhost:" + port + "/tasks/" + test.getTask().getId());
	}

}
