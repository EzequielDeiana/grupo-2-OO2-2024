
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo.serviceInterfaces.IProducto;
import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.repository.IProductoRepository;

@Service
public class ProductoService implements IProducto {

	@Autowired
	private IProductoRepository productoRepository;

	// Query
	@SuppressWarnings("deprecation")
	public Producto getById(int id) {
		return productoRepository.getById(id);
	}

	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	// CUD
	public int agregar(Producto c) {
		return productoRepository.save(c).getId();

	}

	public void delete(int id) {
		if (id != 0)
			productoRepository.deleteById(id);
	}

	@Override
	public Optional<Producto> findById(int id) throws Exception {
		return productoRepository.findById(id);
	}

	@Override
	public Optional<Producto> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Producto insertOrUpdate(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
