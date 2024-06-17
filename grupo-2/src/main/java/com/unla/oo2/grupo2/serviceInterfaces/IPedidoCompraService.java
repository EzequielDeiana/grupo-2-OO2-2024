package com.unla.oo2.grupo2.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.unla.oo2.grupo2.entity.PedidoCompra;

public interface IPedidoCompraService {
	public List<PedidoCompra> findAll();

	public Optional<PedidoCompra> findById(int id);

	public void add(PedidoCompra pedidoCompra);

	public void delete(int id);
	
	public List<PedidoCompra> findPedidoCompraNoComprado();

}
