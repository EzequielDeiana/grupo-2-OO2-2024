
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.repository.IProductoRepository;
import com.unla.oo2.grupo2.serviceInterfaces.IProductoService;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	public Optional<Producto> findById(int id) {
		return productoRepository.findById(id);
	}

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public List<Producto> findProductos() {

		return productoRepository.findProductos();
	}

	public List<Producto> findProductosDisponibles() {
		return productoRepository.findProductosDisponibles();
	}

	public void add(Producto producto) {
		productoRepository.save(producto);
	}

	public void delete(int id) {
		if (id != 0) {
			productoRepository.deleteById(id);
		}
	}

	@Transactional
	public void disable(int id) {
		if (id != 0) {
			productoRepository.DisableProductosById(id);
		}
	}

}
