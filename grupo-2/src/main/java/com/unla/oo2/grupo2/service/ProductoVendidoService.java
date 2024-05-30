
package com.unla.oo2.grupo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.ProductoVendido;
import com.unla.oo2.grupo2.repository.IProductoVendidoRepository;

@Service
public class ProductoVendidoService {

	@Autowired
	IProductoVendidoRepository prodVenRepo;

// Query
	public ProductoVendido getById(int id) {
		return prodVenRepo.getReferenceById(id);
	}

	public List<ProductoVendido> getAll() {
		return prodVenRepo.findAll();
	}

//CUD
	public int agregar(ProductoVendido c) {
		return prodVenRepo.save(c).getId();

	}

	public void delete(int id) {

		if (id != 0)
			prodVenRepo.deleteById(id);
	}

}
