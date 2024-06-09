
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Compra;
import com.unla.oo2.grupo2.repository.ICompraRepository;
import com.unla.oo2.grupo2.serviceInterfaces.ICompraService;

@Service
public class CompraService implements ICompraService {

	@Autowired
	private ICompraRepository compraRepository;

	public Optional<Compra> findById(int id) {
		return compraRepository.findById(id);
	}

	public List<Compra> findAll() {
		return compraRepository.findAll();
	}

	public void add(Compra c) {
		compraRepository.save(c).getId();
	}

	public void delete(int id) {
		if (id != 0) {
			compraRepository.deleteById(id);
		}
	}
}
