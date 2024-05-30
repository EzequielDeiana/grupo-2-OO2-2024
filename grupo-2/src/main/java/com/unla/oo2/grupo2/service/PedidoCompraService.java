
package com.unla.oo2.grupo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.repository.IPedidoCompraRepository;

@Service
public class PedidoCompraService {

	@Autowired
	IPedidoCompraRepository pedCompraRepo;

// Query
	public PedidoCompra getById(int id) {
		return pedCompraRepo.getReferenceById(id);
	}

	public List<PedidoCompra> getAll() {
		return pedCompraRepo.findAll();
	}

//CUD
	public int agregar(PedidoCompra c) {
		return pedCompraRepo.save(c).getId();

	}

	public void delete(int id) {

		if (id != 0)
			pedCompraRepo.deleteById(id);
	}

}
