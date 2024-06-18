
package com.unla.oo2.grupo2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Producto;
import com.unla.oo2.grupo2.entity.Venta;
import com.unla.oo2.grupo2.helper.CantidadProductos;
import com.unla.oo2.grupo2.repository.IProductoRepository;
import com.unla.oo2.grupo2.repository.IVentaRepository;
import com.unla.oo2.grupo2.serviceInterfaces.IVentaService;

@Service
public class VentaService implements IVentaService {

	@Autowired
	IVentaRepository ventaRepository;

	@Autowired
	IProductoRepository productoRepository;

	public Optional<Venta> findById(int id) {
		return ventaRepository.findById(id);
	}

	public List<Venta> findAll() {
		return ventaRepository.findAll();
	}

	public List<Venta> findAllClient(int id) {
		return ventaRepository.findAllClient(id);
	}

	public void add(Venta venta) {
		ventaRepository.save(venta);
	}

	public void delete(int id) {
		if (id != 0) {
			ventaRepository.deleteById(id);
		}
	}

	private void sumarPosicionEntero(List<CantidadProductos> cantidadProductos, int idProducto, int cantidad) {
		for (CantidadProductos i : cantidadProductos) {
			if (i.getIdProducto() == idProducto) {
				i.setCantidad(i.getCantidad() + cantidad);
			}
		}
	}

	public List<CantidadProductos> productosMasMenosVendido(boolean masVendido) {
		List<Venta> ventas = ventaRepository.findAll();
		List<CantidadProductos> cantidadProductos = new ArrayList<CantidadProductos>();

		for (Producto producto : productoRepository.findAll()) {
			cantidadProductos.add(new CantidadProductos(producto.getId(), 0, "", 0));
		}

		for (Venta venta : ventas) {
			sumarPosicionEntero(cantidadProductos, venta.getProducto().getId(), venta.getCantidad());
		}

		if(masVendido)
		{
				cantidadProductos.sort((c1,c2) -> (int) (c2.getCantidad() - c1.getCantidad()));
		}
		else
		{
			cantidadProductos.sort((c1,c2) -> (int) (c1.getCantidad() - c2.getCantidad()));
		}
	
		for (CantidadProductos i : cantidadProductos) {
			Producto producto = productoRepository.findById(i.getIdProducto()).get();
			i.setNombre(producto.getNombre());
			i.setPrecio(producto.getPrecio());
		}

		return cantidadProductos;
	}
}
