package com.unla.oo2.grupo2.dtos;

import java.time.LocalDate;

import com.unla.oo2.grupo2.entity.PedidoCompra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompraDTO {
	private PedidoCompra pedidoCompra;
	private int id;
    private LocalDate fechaEntrega;
    private LocalDate fechaLanzamiento;
    private String proveedor;
    private int cantidadComprada;

   

	public CompraDTO(PedidoCompra pedidoCompra, LocalDate fechaEntrega, LocalDate fechaLanzamiento, String proveedor,
			int cantidadComprada) {
		super();
		this.pedidoCompra = pedidoCompra;
		this.fechaEntrega = fechaEntrega;
		this.fechaLanzamiento = fechaLanzamiento;
		this.proveedor = proveedor;
		this.cantidadComprada = cantidadComprada;
	}
	
	public CompraDTO(PedidoCompra pedidoCompra) {
		super();
		this.pedidoCompra = pedidoCompra;
	}
}
