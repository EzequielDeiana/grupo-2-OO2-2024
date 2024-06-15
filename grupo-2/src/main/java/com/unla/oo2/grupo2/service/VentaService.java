
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.repository.IVentaRepository;
import com.unla.oo2.grupo2.serviceInterfaces.IVentaService;

@Service
public class VentaService implements IVentaService {

	@Autowired
	IVentaRepository ventaRepository;

	public Optional<Venta> findById(int id) {
		return ventaRepository.findById(id);
	}

	public List<Venta> findAll() {
		return ventaRepository.findAll();
	}
	
	public List<Venta> findAllClient(int id) {
		return ventaRepository.findAllClient(id);
	}

	public void add(Venta venta) {
		ventaRepository.save(venta);
	}

	public void delete(int id) {
		if (id != 0) {
			ventaRepository.deleteById(id);
		}
	}

}
