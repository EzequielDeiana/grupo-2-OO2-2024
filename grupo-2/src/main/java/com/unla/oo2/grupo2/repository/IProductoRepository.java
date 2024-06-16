package com.unla.oo2.grupo2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unla.oo2.grupo2.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Serializable> {

	@Query("SELECT p FROM Producto p where p.stockRestante > 0 and p.activo= true")
	public abstract List<Producto> findProductosDisponibles();
	
	@Query("SELECT p FROM Producto p where p.stockRestante > 0 ")
	public abstract List<Producto> findProductos();
	
	@Modifying
    @Transactional
    @Query("UPDATE Producto p SET p.activo = false WHERE p.id = :id")
    void DisableProductosById(int id);

	
}
