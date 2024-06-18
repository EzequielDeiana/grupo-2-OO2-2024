package com.unla.oo2.grupo2.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.helper.CantidadProductos;

public interface IVentaService {
	public List<Venta> findAll();

	public Optional<Venta> findById(int id);

	public void add(Venta venta);

	public void delete(int id);

	public List<Venta> findAllClient(int id);
	
	public List<CantidadProductos> productosMasMenosVendido(boolean masVendido);

}
