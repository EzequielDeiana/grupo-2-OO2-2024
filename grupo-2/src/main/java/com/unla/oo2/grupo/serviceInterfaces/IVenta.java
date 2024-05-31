package com.unla.oo2.grupo.serviceInterfaces;

import java.util.List;
import java.util.Optional;


import com.unla.oo2.grupo2.entity.Venta;

public interface IVenta {

	public List<Venta> getAll();

	public Optional<Venta> findById(long id) throws Exception;

	//public Optional<Venta> findByName(String name) throws Exception;

	public Venta insertOrUpdate(Venta venta);

	public boolean remove(int id);
}