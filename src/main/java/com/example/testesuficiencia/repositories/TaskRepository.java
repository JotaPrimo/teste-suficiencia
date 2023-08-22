package com.example.testesuficiencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.testesuficiencia.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>  {

}
