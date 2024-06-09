
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

	public Optional<PedidoCompra> findById(int id) {
		return pedidoCompraRepository.findById(id);
	}

	public List<PedidoCompra> findAll() {
		return pedidoCompraRepository.findAll();
	}

	public void add(PedidoCompra c) {
		pedidoCompraRepository.save(c);
	}

	public void delete(int id) {
		if (id != 0) {
			pedidoCompraRepository.deleteById(id);
		}
	}

}
