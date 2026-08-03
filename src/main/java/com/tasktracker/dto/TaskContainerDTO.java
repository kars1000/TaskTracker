package com.tasktracker.dto;

import java.util.List;

public class TaskContainerDTO {

	private TaskDTO task;
	private List<TaskDTO> tasks;

	public TaskContainerDTO() {
		super();
	}

	public TaskContainerDTO(List<TaskDTO> tasks) {
		super();
		this.tasks = tasks;
	}

	public List<TaskDTO> getTasks() {
		return tasks;
	}

	public TaskContainerDTO(TaskDTO task) {
		super();
		this.task = task;
	}

	public TaskDTO getTask() {
		return task;
	}

}
