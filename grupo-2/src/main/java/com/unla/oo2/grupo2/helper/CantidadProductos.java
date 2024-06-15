package com.unla.oo2.grupo2.helper;

public class CantidadProductos {
    public int idProducto;
    public int cantidad;
    public String nombre;
    public double precio;

    public CantidadProductos() {
        super();
    }

    public CantidadProductos(int idProducto, int cantidad, String nombre, double precio) {
        super();
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }

}