
package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor
@Table(name="compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(optional=false)@JoinColumn(name = "pedidoCompra")
	private PedidoCompra pedidoCompra;
	@Column(name = "fechaEntrega")
	private LocalDate fechaEntrega;
	@Column(name = "fechaLanzamiento")
	private LocalDate fechaLanzamiento;
	@Column(name = "proveedor")
	private String proveedor;
	@Column(name = "cantidadComprada")
	private int cantidadComprada;
	
	public Compra(PedidoCompra pedidoCompra, LocalDate fechaEntrega, LocalDate fechaLanzamiento, String proveedor,
			int cantidadComprada) {
		super();
		this.pedidoCompra = pedidoCompra;
		this.fechaEntrega = fechaEntrega;
		this.fechaLanzamiento = fechaLanzamiento;
		this.proveedor = proveedor;
		this.cantidadComprada = cantidadComprada;
	}
	
	
	
}
