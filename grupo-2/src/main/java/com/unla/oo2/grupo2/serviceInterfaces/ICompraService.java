package com.unla.oo2.grupo2.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.unla.oo2.grupo2.entity.Compra;

public interface ICompraService {
	public List<Compra> findAll();

	public Optional<Compra> findById(int id);

	public void add(Compra compra);

	public void delete(int id);
}
