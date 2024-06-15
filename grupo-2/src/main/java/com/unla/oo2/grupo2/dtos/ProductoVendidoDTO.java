package com.unla.oo2.grupo2.dtos;

import com.unla.oo2.grupo2.entity.Producto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoVendidoDTO {

	private int id;
	private Producto producto;
	private int ventaId;
	private int cantidad;
	private double precioTotal;

	public ProductoVendidoDTO(int id, Producto producto, int ventaId, int cantidad, double precioTotal) {
		this.id = id;
		this.producto = producto;
		this.ventaId = ventaId;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
	}
}
