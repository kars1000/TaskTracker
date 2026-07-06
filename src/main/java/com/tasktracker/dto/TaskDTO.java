package com.tasktracker.dto;

import com.tasktracker.entity.Task;

public class TaskDTO {
	
	private String taskDescription;
	private long id;

	public TaskDTO(Task task) {
		super();
		this.taskDescription = task.getTaskDescription();
		this.id = task.getId();
	}

	

	public long getId() {
		return id;
	}



	public TaskDTO() {
		super();
	}



	public String getTaskDescription() {
		return taskDescription;
	}

}
