package com.unla.oo2.grupo2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unla.oo2.grupo2.entity.PedidoCompra;

public interface IPedidoCompraRepository extends JpaRepository<PedidoCompra, Serializable> {
	
	@Query("SELECT pc FROM PedidoCompra pc JOIN FETCH pc.producto p WHERE pc.comprado = false")
	public List<PedidoCompra> findPedidoCompraNoComprado();
}
