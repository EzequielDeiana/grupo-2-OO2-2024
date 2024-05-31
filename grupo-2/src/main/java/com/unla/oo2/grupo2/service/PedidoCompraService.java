
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo.serviceInterfaces.IPedidoCompra;
import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.repository.IPedidoCompraRepository;

@Service
public class PedidoCompraService implements IPedidoCompra {

	@Autowired
	private IPedidoCompraRepository pedidoCompraRepository;

	// Query
	public PedidoCompra getById(int id) {
		return pedidoCompraRepository.getReferenceById(id);
	}

	public List<PedidoCompra> getAll() {
		return pedidoCompraRepository.findAll();
	}

	// CUD
	public int agregar(PedidoCompra c) {
		return pedidoCompraRepository.save(c).getId();

	}

	public void delete(int id) {

		if (id != 0)
			pedidoCompraRepository.deleteById(id);
	}

	@Override
	public Optional<PedidoCompra> findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public PedidoCompra insertOrUpdate(PedidoCompra pedidocompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
