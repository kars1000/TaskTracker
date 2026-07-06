package com.tasktracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Task {

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Integer version;

	private String taskDescription;

	public Task() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public Task(String taskDescription) {
		super();
		this.taskDescription = taskDescription;
	}

}
