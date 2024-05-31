
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo.serviceInterfaces.IVenta;
import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.repository.IVentaRepository;

@Service
public class VentaService implements IVenta {

	@Autowired
	IVentaRepository ventaRepository;


	// Query
	public Venta getById(int id) {
		return ventaRepository.getReferenceById(id);
	}

	public List<Venta> getAll() {
		return ventaRepository.findAll();
	}

	//CUD
	public int agregar(Venta c) {
		return ventaRepository.save(c).getId();
	}

	public void delete(int id) {
		if (id != 0)
			ventaRepository.deleteById(id);
	}

	@Override
	public Optional<Venta> findById(int id) throws Exception {
		return ventaRepository.findById(id);
	}

	@Override
	public Venta insertOrUpdate(Venta venta) {
		return ventaRepository.save(venta);
	}

	@Override
	public boolean remove(int id) {
		if (id != 0)
			ventaRepository.deleteById(id);
		return false;
	}

}
