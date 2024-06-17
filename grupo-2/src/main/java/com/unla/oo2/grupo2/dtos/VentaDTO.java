package com.unla.oo2.grupo2.dtos;

import java.time.LocalDate;

import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VentaDTO {
	private int id;
	private LocalDate fechaVenta;
	private int cantidad;
	private User cliente;

	private double totalVenta;

	private Producto producto;

	public VentaDTO(LocalDate fechaVenta, User cliente, double totalVenta, Producto producto, int cantidad) {
		super();
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.totalVenta = totalVenta;
		this.producto = producto;
		this.cantidad = cantidad;
	}
}
