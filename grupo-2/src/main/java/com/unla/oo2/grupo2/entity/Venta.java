package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor
public class Venta {
	private LocalDate fechaVenta;
	private List<ProductoVendido> productosComprados;
	private Cliente cliente;
	private double totalVenta;
	
	
	public Venta(LocalDate fechaVenta, Cliente cliente, double totalVenta) {
		super();
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.totalVenta = totalVenta;
	}
	
	
	
}
