/*
 * package com.unla.oo2.grupo2.entity;
 * 
 * import java.time.LocalDate;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.Table; import lombok.Data; import
 * lombok.NoArgsConstructor;
 * 
 * @Entity
 * 
 * @Data @NoArgsConstructor
 * 
 * @Table(name="productoTransaccion") public class ProductoTransaccion {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
 * 
 * @Column(name = "producto") private Producto producto;
 * 
 * @Column(name = "cantidad") private int cantidad;
 * 
 * @Column(name = "precioTotal") private double precioTotal;
 * 
 * @Column(name = "fechaIngreso") private LocalDate fechaIngreso;
 * 
 * public ProductoTransaccion(Producto producto, int cantidad, double
 * precioTotal, LocalDate fechaIngreso) { super(); this.producto = producto;
 * this.cantidad = cantidad; this.precioTotal = precioTotal; this.fechaIngreso =
 * fechaIngreso; }
 * 
 * 
 * }
 */