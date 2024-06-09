package com.unla.oo2.grupo2.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.unla.oo2.grupo2.entity.ProductoVendido;

public interface IProductoVendidoService {
	public List<ProductoVendido> findAll();

	public Optional<ProductoVendido> findById(int id) throws Exception;

	public void add(ProductoVendido productoVendido);

	public void delete(int id);
}
