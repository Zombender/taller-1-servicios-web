package org.jerr.productos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @Column(name = "presentacion", nullable = false, length = 10)
    private String presentacion;
    @Column(name = "categoria", nullable = false, length = 30)
    private String categoria;
    @Column(name = "disponible", nullable = false)
    private boolean disponible;


}
