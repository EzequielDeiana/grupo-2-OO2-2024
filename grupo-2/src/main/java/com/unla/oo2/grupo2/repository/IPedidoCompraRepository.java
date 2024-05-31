package com.unla.oo2.grupo2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.oo2.grupo2.entity.PedidoCompra;

public interface IPedidoCompraRepository extends JpaRepository<PedidoCompra, Serializable> {

}