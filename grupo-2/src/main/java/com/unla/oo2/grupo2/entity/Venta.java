
package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "venta")
public class Venta 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fechaVenta")
	private LocalDate fechaVenta;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
	private Set<ProductoVendido> productosComprados;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente")
	private Cliente cliente;
	
	@Column(name = "totalVenta")
	private double totalVenta;

	public Venta(LocalDate fechaVenta, Cliente cliente, double totalVenta) {
		super();
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.totalVenta = totalVenta;
	}

}