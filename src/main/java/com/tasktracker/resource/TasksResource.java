package com.tasktracker.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tasktracker.dto.TaskContainerDTO;
import com.tasktracker.dto.TaskDTO;
import com.tasktracker.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TasksResource {

	private TaskService taskService;

	public TasksResource(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	@GetMapping()
	public TaskContainerDTO getTasks() {

		return taskService.findAllTasks();

	}

	@GetMapping("/{id}")
	public TaskContainerDTO getTask(@PathVariable long id) {

		return taskService.findTask(id);

	}

	@PostMapping
	public TaskContainerDTO createTask(@RequestBody TaskDTO taskDTO) {

		return taskService.createTask(taskDTO);

	}

	@PutMapping("/{id}")
	public void updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO) {
		taskService.updateTask(id, taskDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable long id) {
		taskService.deleteTask(id);
	}

}
