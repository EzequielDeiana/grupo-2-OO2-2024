
package com.unla.oo2.grupo2.entity;

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
@Table(name = "productoVendido")
public class ProductoVendido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "producto")
	private Producto producto;
	@ManyToOne(optional = false)
	@JoinColumn(name = "venta")
	private Venta venta;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "precioTotal")
	private double precioTotal;

	public ProductoVendido(Producto producto, Venta venta, int cantidad, double precioTotal) {
		super();
		this.producto = producto;
		this.venta = venta;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
	}

}