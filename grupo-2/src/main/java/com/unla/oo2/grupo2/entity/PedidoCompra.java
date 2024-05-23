
package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pedidoCompra")
public class PedidoCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional=false)@JoinColumn(name="producto")
	private Producto producto;
	@Column(name = "fechaLanzamiento")
	private LocalDate fechaLanzamiento;
	@Column(name = "comprado")
	private boolean comprado;
	@Column(name = "cantidadSolicitada")
	private int cantidadSolicitada;

	public PedidoCompra(Producto producto, LocalDate fechaLanzamiento, boolean comprado, int cantidadSolicitada) {
		super();
		this.producto = producto;
		this.fechaLanzamiento = fechaLanzamiento;
		this.comprado = comprado;
		this.cantidadSolicitada = cantidadSolicitada;
	}

}
