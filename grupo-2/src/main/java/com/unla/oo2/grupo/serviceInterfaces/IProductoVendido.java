package com.unla.oo2.grupo.serviceInterfaces;

import java.util.List;
import java.util.Optional;


import com.unla.oo2.grupo2.entity.ProductoVendido;

public interface IProductoVendido {

	public List<ProductoVendido> getAll();

	public Optional<ProductoVendido> findById(long id) throws Exception;

	//public Optional<ProductoVendido> findByName(String name) throws Exception;

	public ProductoVendido insertOrUpdate(ProductoVendido productovendido);

	public boolean remove(int id);

}
