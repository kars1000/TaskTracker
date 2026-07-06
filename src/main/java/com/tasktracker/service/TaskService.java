package com.tasktracker.service;

import com.tasktracker.dto.TaskContainerDTO;
import com.tasktracker.dto.TaskDTO;

public interface TaskService {
	
	/**
	 * 
	 * @param taskDTO
	 * @return
	 */
	public TaskContainerDTO createTask(TaskDTO taskDTO);
	

	/**
	 * 
	 * @param taskDTO
	 * @return
	 */
	public TaskContainerDTO updateTask(TaskDTO taskDTO);

}
