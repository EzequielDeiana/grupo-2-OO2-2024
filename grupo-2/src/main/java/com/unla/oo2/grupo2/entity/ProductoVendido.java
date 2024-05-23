package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor
public class ProductoVendido {
	private Producto producto;
	private int cantidad;
	private double precioTotal;
	
	public ProductoVendido(Producto producto, int cantidad, double precioTotal) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
	}
	
	
	
}
