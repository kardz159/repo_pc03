package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Categoria;

public interface CategoriaService {

	public List<Categoria> listarCategoria();
	public Categoria obtenerCategoria(int id);
}
