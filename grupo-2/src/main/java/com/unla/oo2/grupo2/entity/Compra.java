package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor
public class Compra {
	private PedidoCompra pedidoCompra;
	private LocalDate fechaEntrega;
	private LocalDate fechaLnzamiento;
	private String proveedor;
	private int cantidadComprada;
	
	public Compra(PedidoCompra pedidoCompra, LocalDate fechaEntrega, LocalDate fechaLnzamiento, String proveedor,
			int cantidadComprada) {
		super();
		this.pedidoCompra = pedidoCompra;
		this.fechaEntrega = fechaEntrega;
		this.fechaLnzamiento = fechaLnzamiento;
		this.proveedor = proveedor;
		this.cantidadComprada = cantidadComprada;
	}
	
	
	
}
