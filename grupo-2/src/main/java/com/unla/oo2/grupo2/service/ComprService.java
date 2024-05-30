
package com.unla.oo2.grupo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Compra;
import com.unla.oo2.grupo2.repository.ICompraRepository;

@Service
public class ComprService {

	@Autowired
	ICompraRepository compraRepo;

// Query
	public Compra getById(int id) {
		return compraRepo.getReferenceById(id);
	}

	public List<Compra> getAll() {
		return compraRepo.findAll();
	}

//CUD
	public int agregar(Compra c) {
		return compraRepo.save(c).getId();

	}

	public void delete(int id) {

		if (id != 0)
			compraRepo.deleteById(id);
	}

}
