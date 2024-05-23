package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor
public class PedidoCompra {
	private Producto producto;
	private LocalDate fechaLanzamiento;
	private boolean comprado;
	private int cantidadSolicitada;
	
	public PedidoCompra(Producto producto, LocalDate fechaLanzamiento, boolean comprado, int cantidadSolicitada) {
		super();
		this.producto = producto;
		this.fechaLanzamiento = fechaLanzamiento;
		this.comprado = comprado;
		this.cantidadSolicitada = cantidadSolicitada;
	}
	
	
	
}
