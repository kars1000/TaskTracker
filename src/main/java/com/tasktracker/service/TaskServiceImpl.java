package com.tasktracker.service;

import org.springframework.stereotype.Service;

import com.tasktracker.dto.TaskContainerDTO;
import com.tasktracker.dto.TaskDTO;
import com.tasktracker.entity.Task;
import com.tasktracker.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	public TaskContainerDTO createTask(TaskDTO taskDTO) {

		Task task = taskRepository.save(new Task(taskDTO.getTaskDescription()));

		return new TaskContainerDTO(new TaskDTO(task));

	}

	@Override
	public TaskContainerDTO updateTask(long id, TaskDTO taskDTO) {
		Task task = taskRepository.findById(id).get();
		task.setTaskDescription(taskDTO.getTaskDescription());
		return new TaskContainerDTO(new TaskDTO(task));
	}

}
