
package com.unla.oo2.grupo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.repository.IProductoRepository;

@Service
public class ProductoService {

	@Autowired
	IProductoRepository prodRepo;

// Query
	public Producto getById(int id) {
		return prodRepo.getReferenceById(id);
	}

	public List<Producto> getAll() {
		return prodRepo.findAll();
	}

//CUD
	public int agregar(Producto c) {
		return prodRepo.save(c).getId();

	}

	public void delete(int id) {

		if (id != 0)
			prodRepo.deleteById(id);
	}

}
