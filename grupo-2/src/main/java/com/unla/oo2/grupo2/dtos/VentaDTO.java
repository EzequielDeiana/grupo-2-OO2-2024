package com.unla.oo2.grupo2.dtos;

import java.time.LocalDate;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VentaDTO {
	private int id;
	private LocalDate fechaVenta;
	private Set<ProductoVendidoDTO> productosComprados;
	private int clienteId;
	private double totalVenta;
	private int productoId;

	public VentaDTO(int id, LocalDate fechaVenta, Set<ProductoVendidoDTO> productosComprados, int clienteId,
			double totalVenta, int productoId) {
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.productosComprados = productosComprados;
		this.clienteId = clienteId;
		this.totalVenta = totalVenta;
		this.productoId = productoId;
	}
}
