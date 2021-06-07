package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Producto;

public interface ProductoService {
	
	public List<Producto> listarProductos();
	public Producto registraActualizaProducto(Producto producto);
	public Optional<Producto> obtenerProducto(int id);
	public List<Producto> listarProductos(int idCategoria);
	public void eliminarProductos(int id);
	
}
