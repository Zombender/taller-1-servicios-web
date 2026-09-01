package org.jerr.productos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
    private Long id;
    private String nombre;
    private String presentacion;
    private String categoria;
    private boolean disponible;
}
