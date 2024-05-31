package com.unla.oo2.grupo.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.unla.oo2.grupo2.entity.PedidoCompra;

public interface IPedidoCompra {
	
	public List<PedidoCompra> getAll();

	public Optional<PedidoCompra> findById(long id) throws Exception;

	public PedidoCompra insertOrUpdate(PedidoCompra pedidocompra);

	public boolean remove(int id);

}
