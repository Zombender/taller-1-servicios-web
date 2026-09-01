package org.jerr.productos.repository;

import lombok.NoArgsConstructor;
import org.jerr.productos.dto.ProductoDTO;
import org.jerr.productos.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class ProductoRepository {
    private final List<Producto> productos = new ArrayList<>();
    private static Long currentId = 1L;

    public List<Producto> findAll() {
        return productos;
    }

    public Optional<Producto> findById(Long id) {
        for (Producto producto : productos) {
            if (Objects.equals(producto.getId(), id)) return Optional.of(producto);
        }
        return Optional.empty();
    }

    public Producto save(Producto producto) {
        producto.setId(currentId);
        currentId++;
        productos.add(producto);
        return producto;
    }

    public Optional<Producto> update(Long id, ProductoDTO productoDTO) {
        Optional<Producto> existingProducto = findById(id);
        if (existingProducto.isPresent()) {
            Producto producto = existingProducto.get();
            producto.setNombre(productoDTO.nombre());
            producto.setPresentacion(productoDTO.presentacion());
            producto.setCategoria(productoDTO.categoria());
            producto.setDisponible(productoDTO.disponible());
            return Optional.of(producto);
        }
        return Optional.empty();
    }

    public void delete(Long id) {
        Optional<Producto> existingProducto = findById(id);
        existingProducto.ifPresent(productos::remove);
    }
}
