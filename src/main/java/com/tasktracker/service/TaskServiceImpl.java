package com.tasktracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.sql.ast.internal.ColumnQualifierCollectorSqlAstWalker;
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

	@Override
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

	@Override
	public TaskContainerDTO findAllTasks() {
		List<TaskDTO> tasks = taskRepository.findAll().stream().map(e -> new TaskDTO(e)).collect(Collectors.toList());
		return new TaskContainerDTO(tasks);
	}

	@Override
	public TaskContainerDTO findTask(long taskId) {
		//return null;
		Task task = taskRepository.findById(taskId).get();

		return new TaskContainerDTO(new TaskDTO(task));
		
	}

	@Override
	public void deleteTask(long taskId) {
		taskRepository.deleteById(taskId);
		
	}

	

}
