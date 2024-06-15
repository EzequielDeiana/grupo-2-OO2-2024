package com.unla.oo2.grupo2.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompraDTO {
	private int id;
    private int pedidoCompraId;
    private LocalDate fechaEntrega;
    private LocalDate fechaLanzamiento;
    private String proveedor;
    private int cantidadComprada;

   

    public CompraDTO(int id, int pedidoCompraId, LocalDate fechaEntrega, LocalDate fechaLanzamiento, String proveedor,
            int cantidadComprada) {
        this.id = id;
        this.pedidoCompraId = pedidoCompraId;
        this.fechaEntrega = fechaEntrega;
        this.fechaLanzamiento = fechaLanzamiento;
        this.proveedor = proveedor;
        this.cantidadComprada = cantidadComprada;
    }
}
