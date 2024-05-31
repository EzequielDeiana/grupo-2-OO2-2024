
package com.unla.oo2.grupo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.repository.IVentaRepository;

@Service
public class VentaService {

	@Autowired
	IVentaRepository ventaRepo;

// Query
	public Venta getById(int id) {
		return ventaRepo.getReferenceById(id);
	}

	public List<Venta> getAll() {
		return ventaRepo.findAll();
	}

//CUD
	public int agregar(Venta c) {
		return ventaRepo.save(c).getId();

	}

	public void delete(int id) {

		if (id != 0)
			ventaRepo.deleteById(id);
	}

}
