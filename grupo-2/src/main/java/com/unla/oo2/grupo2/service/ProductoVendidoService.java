
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo.serviceInterfaces.IProductoVendido;
import com.unla.oo2.grupo2.entity.ProductoVendido;
import com.unla.oo2.grupo2.repository.IProductoVendidoRepository;

@Service
public class ProductoVendidoService implements IProductoVendido {

	@Autowired
	private IProductoVendidoRepository productoVendidoRepository;

	// Query
	public ProductoVendido getById(int id) {
		return productoVendidoRepository.getReferenceById(id);
	}

	public List<ProductoVendido> getAll() {
		return productoVendidoRepository.findAll();
	}

	// CUD
	public int agregar(ProductoVendido c) {
		return productoVendidoRepository.save(c).getId();

	}

	public void delete(int id) {
		if (id != 0)
			productoVendidoRepository.deleteById(id);
	}

	@Override
	public Optional<ProductoVendido> findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public ProductoVendido insertOrUpdate(ProductoVendido productovendido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
