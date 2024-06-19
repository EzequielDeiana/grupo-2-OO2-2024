
package com.unla.oo2.grupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.PedidoCompra;
import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.repository.IPedidoCompraRepository;
import com.unla.oo2.grupo2.serviceInterfaces.IPedidoCompraService;

@Service
public class PedidoCompraService implements IPedidoCompraService {

	@Autowired
	private IPedidoCompraRepository pedidoCompraRepository;

	public Optional<PedidoCompra> findById(int id) {
		return pedidoCompraRepository.findById(id);
	}

	public List<PedidoCompra> findAll() {
		return pedidoCompraRepository.findAll();
	}

	public List<PedidoCompra> findPedidoCompraNoComprado() {
		return pedidoCompraRepository.findPedidoCompraNoComprado();
	}

	
	public PedidoCompra findPedidoCompraNoComprado(Producto p)
	{
		PedidoCompra pc = null;
		
		List<PedidoCompra> lista = findPedidoCompraNoComprado();
		int j = 0;

		while (j < lista.size() && pc == null) {
			if (lista.get(j).getProducto().getId() == p.getId()) {
				pc = lista.get(j);
			}
			j++;
		}		
		return pc;	
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
