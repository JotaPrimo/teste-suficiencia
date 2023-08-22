package com.example.testesuficiencia.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testesuficiencia.models.Task;
import com.example.testesuficiencia.repositories.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@PostMapping
	public Task store(@RequestBody Task task) {
		return taskRepository.save(task);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
		Optional<Task> taskOpt = taskRepository.findById(id);
		if (taskOpt.isPresent()) {
			Task taskExiste = taskOpt.get();
			taskExiste.setTitle(task.getTitle());
			taskExiste.setCompleted(task.isCompleted());

			Task taskAtualizado = taskRepository.save(taskExiste);
			return ResponseEntity.ok(taskAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Optional<Task> taskOpt = taskRepository.findById(id);

		if (taskOpt.isPresent()) {
			taskRepository.deleteById(id);

			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping("/{id}/complete")
	public ResponseEntity<?> completeTask(@PathVariable Long id) {
		Optional<Task> taskOptional = taskRepository.findById(id);

		if (taskOptional.isPresent()) {
			Task task = taskOptional.get();
			task.setCompleted(true);
			taskRepository.save(task);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
