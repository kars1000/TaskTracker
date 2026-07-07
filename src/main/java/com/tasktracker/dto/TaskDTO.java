package com.tasktracker.dto;

import com.tasktracker.entity.Task;

public class TaskDTO {
	
	public TaskDTO(String taskDescription) {
		super();
		this.taskDescription = taskDescription;
	}



	private String taskDescription;
	private Long id;

	public TaskDTO(Task task) {
		super();
		this.taskDescription = task.getTaskDescription();
		this.id = task.getId();
	}

	

	public Long getId() {
		return id;
	}



	public TaskDTO() {
		super();
	}



	public String getTaskDescription() {
		return taskDescription;
	}

}
