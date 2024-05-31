package com.unla.oo2.grupo.serviceInterfaces;

import java.util.List;
import java.util.Optional;


import com.unla.oo2.grupo2.entity.Producto;

public interface IProducto {
	
	public List<Producto> getAll();

	public Optional<Producto> findById(int id) throws Exception;

	public Optional<Producto> findByName(String name) throws Exception;

	public Producto insertOrUpdate(Producto producto);

	public boolean remove(int id);

	public Producto getById(int id);

	public int agregar(Producto c);

	public void delete(int id);
}
