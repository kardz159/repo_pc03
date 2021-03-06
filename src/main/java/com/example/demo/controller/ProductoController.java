package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/rest/producto")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping
	public List<Producto> listarProducto() {
		return service.listarProductos();
	}
	
	@PostMapping
	public Producto registrarProducto(@RequestBody Producto producto) {
		return service.registraActualizaProducto(producto);
	}
	
	@PutMapping
	public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
		Optional<Producto> optProducto = service.obtenerProducto(producto.getIdProducto());
		if (optProducto.isPresent()) {
			return ResponseEntity.ok(service.registraActualizaProducto(producto));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> elimina(@PathVariable("id") int idProducto) {
		Optional<Producto> optProducto = service.obtenerProducto(idProducto);
		if(optProducto.isPresent()) {
			service.eliminarProductos(idProducto);
			return ResponseEntity.ok(optProducto.get());
		} else {
			return ResponseEntity.notFound().build();
	}
	}
	
}
