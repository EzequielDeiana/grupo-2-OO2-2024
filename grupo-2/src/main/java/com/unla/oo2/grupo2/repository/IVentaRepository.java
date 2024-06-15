package com.unla.oo2.grupo2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.oo2.grupo2.entity.Venta;

public interface IVentaRepository extends JpaRepository<Venta, Serializable> {

	@Query("SELECT v FROM Venta v where v.cliente.id = (:id)")
	public abstract List<Venta> findAllClient(@Param("id") int id);
}
