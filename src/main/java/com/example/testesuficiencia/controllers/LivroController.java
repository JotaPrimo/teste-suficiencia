package com.example.testesuficiencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testesuficiencia.models.Livro;
import com.example.testesuficiencia.repositories.ILivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private ILivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> index() {
		return livroRepository.findAll();
	}
	
	@PostMapping
	public Livro store(@RequestBody Livro livro) {
		return livroRepository.save(livro);
	}
	
	
}
