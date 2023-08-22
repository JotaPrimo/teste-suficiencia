package com.example.testesuficiencia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;	
	
	private String autor;	
	
	private Integer versao;
	
	private String categoria;
	

	public Livro() {
		// TODO Auto-generated constructor stub
	}


	public Livro(String titulo, String autor, Integer versao, String categoria) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.versao = versao;
		this.categoria = categoria;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Integer getVersao() {
		return versao;
	}


	public void setVersao(Integer versao) {
		this.versao = versao;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
