package com.unla.oo2.grupo.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.unla.oo2.grupo2.entity.Compra;

public interface ICompraServices {
	
	public List<Compra> getAll();

	public Optional<Compra> findById(long id) throws Exception;

	public Optional<Compra> findByName(String name) throws Exception;

	public Compra insertOrUpdate(Compra compra);

	public boolean remove(int id);


}
