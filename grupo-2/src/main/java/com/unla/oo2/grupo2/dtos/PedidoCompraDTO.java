package com.unla.oo2.grupo2.dtos;

import java.time.LocalDate;

import com.unla.oo2.grupo2.entity.Producto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidoCompraDTO {

	private int id;
	private Producto producto;
	private LocalDate fechaLanzamiento;
	private boolean comprado;
	private int cantidadSolicitada;

	public PedidoCompraDTO(int id, Producto producto, LocalDate fechaLanzamiento, boolean comprado,
			int cantidadSolicitada) {
		this.id = id;
		this.producto = producto;
		this.fechaLanzamiento = fechaLanzamiento;
		this.comprado = comprado;
		this.cantidadSolicitada = cantidadSolicitada;
	}
}
