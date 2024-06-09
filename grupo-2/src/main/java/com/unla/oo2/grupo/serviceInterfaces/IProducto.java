package com.unla.oo2.grupo.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.unla.oo2.grupo2.entity.Producto;

public interface IProducto {
	public List<Producto> findAll();

	public Optional<Producto> findById(int id) throws Exception;

	public List<Producto> findProductosDisponibles();

	public void add(Producto producto);

	public void delete(int id);
}
