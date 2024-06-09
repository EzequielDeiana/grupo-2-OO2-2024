package com.unla.oo2.grupo.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.unla.oo2.grupo2.entity.Venta;

public interface IVentaService {
	public List<Venta> findAll();

	public Optional<Venta> findById(int id);

	public void add(Venta venta);

	public void delete(int id);
}
