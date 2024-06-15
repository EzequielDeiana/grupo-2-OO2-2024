package com.unla.oo2.grupo2.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoVendidoDTO {

	private int id;
	private int productoId;
	private int ventaId;
	private int cantidad;
	private double precioTotal;

	public ProductoVendidoDTO(int id, int productoId, int ventaId, int cantidad, double precioTotal) {
		this.id = id;
		this.productoId = productoId;
		this.ventaId = ventaId;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
	}
}
