package com.unla.oo2.grupo2.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidoCompraDTO {

	private int id;
	private int productoId;
	private LocalDate fechaLanzamiento;
	private boolean comprado;
	private int cantidadSolicitada;

	public PedidoCompraDTO(int id, int productoId, LocalDate fechaLanzamiento, boolean comprado,
			int cantidadSolicitada) {
		this.id = id;
		this.productoId = productoId;
		this.fechaLanzamiento = fechaLanzamiento;
		this.comprado = comprado;
		this.cantidadSolicitada = cantidadSolicitada;
	}
}
