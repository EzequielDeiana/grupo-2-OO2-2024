package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor
public class ProductoTransaccion {
	private Producto producto;
	private int cantidad;
	private double precioTotal;
	private LocalDate fechaIngreso;
	
	public ProductoTransaccion(Producto producto, int cantidad, double precioTotal, LocalDate fechaIngreso) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.fechaIngreso = fechaIngreso;
	}
		
	
}
