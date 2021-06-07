package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository repository;

	@Override
	public List<Producto> listarProductos() {
		return repository.findAll();
	}

	@Override
	public Producto registraActualizaProducto(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public Optional<Producto> obtenerProducto(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Producto> listarProductos(int idCategoria) {
		return repository.buscarProductosCategoria(idCategoria);
	}

	@Override
	public void eliminarProductos(int id) {
		repository.deleteById(id);
	}
}
