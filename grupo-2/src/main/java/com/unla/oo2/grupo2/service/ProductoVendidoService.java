
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo.serviceInterfaces.IProductoVendidoService;
import com.unla.oo2.grupo2.entity.ProductoVendido;
import com.unla.oo2.grupo2.repository.IProductoVendidoRepository;

@Service
public class ProductoVendidoService implements IProductoVendidoService {
	
	@Autowired
	private IProductoVendidoRepository productoVendidoRepository;

	public Optional<ProductoVendido> findById(int id) {
		return productoVendidoRepository.findById(id);
	}

	public List<ProductoVendido> findAll() {
		return productoVendidoRepository.findAll();
	}

	public void add(ProductoVendido productoVendido) {
		productoVendidoRepository.save(productoVendido);
	}

	public void delete(int id) {
		if (id != 0) {
			productoVendidoRepository.deleteById(id);
		}
	}

}
