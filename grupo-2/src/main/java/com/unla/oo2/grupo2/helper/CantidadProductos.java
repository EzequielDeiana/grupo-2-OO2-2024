package com.unla.oo2.grupo2.helper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CantidadProductos {
	private int idProducto;
	private int cantidad;
	private String nombre;
	private double precio;

	public CantidadProductos(int idProducto, int cantidad, String nombre, double precio) {
		super();
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.precio = precio;
	}

}