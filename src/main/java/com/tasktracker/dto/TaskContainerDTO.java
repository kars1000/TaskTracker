package com.tasktracker.dto;

public class TaskContainerDTO {
	
	private TaskDTO task;

	public TaskContainerDTO(TaskDTO task) {
		super();
		this.task = task;
	}

	
	public TaskDTO getTask() {
		return task;
	}

}
