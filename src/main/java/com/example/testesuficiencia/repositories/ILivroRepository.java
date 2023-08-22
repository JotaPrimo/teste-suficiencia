package com.example.testesuficiencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testesuficiencia.models.Livro;

public interface ILivroRepository extends JpaRepository<Livro, Long> {

}
