package com.unla.oo2.grupo2.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor
public class Producto {
	private String nombre;
	private String descripcion;
	private String tipo;
	private int stockRestante;
	private double precio;
	private boolean activo;

	public Producto(String nombre, String descripcion, String tipo, int stockRestante, double precio,
			boolean activo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.stockRestante = stockRestante;
		this.precio = precio;
		this.activo = activo;
	}

}
