package com.unla.oo2.grupo.serviceInterfaces;

import java.util.List;
import java.util.Optional;


import com.unla.oo2.grupo2.entity.Producto;

public interface IProducto {
	
	public List<Producto> getAll();

	public Optional<Producto> findById(long id) throws Exception;

	public Optional<Producto> findByName(String name) throws Exception;

	public Producto insertOrUpdate(Producto producto);

	public boolean remove(int id);
}