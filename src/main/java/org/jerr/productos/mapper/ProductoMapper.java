package org.jerr.productos.mapper;

import org.jerr.productos.dto.ProductoDTO;
import org.jerr.productos.entity.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDTO toDto(Producto producto);
    Producto toEntity(ProductoDTO productoDTO);
}
