package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaRepository repository;

	@Override
	public List<Categoria> listarCategoria() {	
		return repository.findAll();
	}

	@Override
	public Categoria obtenerCategoria(int id) {
		return repository.findById(id).get();
	}
	
	

}
