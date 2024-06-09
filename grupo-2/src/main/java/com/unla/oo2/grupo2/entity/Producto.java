
package com.unla.oo2.grupo2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "stockRestante")
	private int stockRestante;

	@Column(name = "precio")
	private double precio;

	@Column(name = "activo")
	private boolean activo;

	public Producto(String nombre, String descripcion, String tipo, int stockRestante, double precio, boolean activo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.stockRestante = stockRestante;
		this.precio = precio;
		this.activo = activo;
	}

}