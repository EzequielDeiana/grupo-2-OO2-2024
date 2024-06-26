
package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fechaVenta")
	private LocalDate fechaVenta;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente")
	private User cliente;

	@Column(name = "totalVenta")
	private double totalVenta;

	@Column(name = "cantidad")
	private int cantidad;

	@ManyToOne(optional = false)
	@JoinColumn(name = "producto")
	private Producto producto;

	public Venta(LocalDate fechaVenta, User cliente, double totalVenta, Producto producto, int cantidad) {
		super();
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.totalVenta = totalVenta;
		this.producto = producto;
		this.cantidad = cantidad;
	}

}