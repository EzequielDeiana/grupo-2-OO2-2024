package com.unla.oo2.grupo2.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {
	private int id;
	private String nombre;
	private String descripcion;
	private String tipo;
	private int stockRestante;
	private double precio;
	private boolean activo;
	private String url;
	
	public ProductoDTO(int id, String nombre, String descripcion, String tipo, int stockRestante, double precio,
			boolean activo, String url) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.stockRestante = stockRestante;
		this.precio = precio;
		this.activo = activo;
		this.url = url;
	}
}
