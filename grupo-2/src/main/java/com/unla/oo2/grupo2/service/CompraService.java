
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo.serviceInterfaces.ICompraServices;
import com.unla.oo2.grupo2.entity.Compra;
import com.unla.oo2.grupo2.repository.ICompraRepository;

@Service
public class CompraService implements ICompraServices {

	@Autowired
	private ICompraRepository compraRepository;

	// Query
	public Compra getById(int id) {
		return compraRepository.getReferenceById(id);
	}

	public List<Compra> getAll() {
		return compraRepository.findAll();
	}

	// CUD
	public int agregar(Compra c) {
		return compraRepository.save(c).getId();

	}

	public void delete(int id) {
		if (id != 0)
			compraRepository.deleteById(id);
	}

	@Override
	public Optional<Compra> findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Compra> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Compra insertOrUpdate(Compra compra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
