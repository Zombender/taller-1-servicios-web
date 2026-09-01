package org.jerr.productos.service;

import jakarta.persistence.EntityNotFoundException;
import org.jerr.productos.dto.ProductoDTO;
import org.jerr.productos.entity.Producto;
import org.jerr.productos.mapper.ProductoMapper;
import org.jerr.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoService(ProductoRepository repository, ProductoMapper mapper) {
        this.productoRepository = repository;
        this.productoMapper = mapper;
    }


    @Transactional(readOnly = true)
    public List<ProductoDTO> getProductos() {
        return productoRepository.findAll().stream().map(productoMapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public ProductoDTO getProductoById(Long id) {
        return productoMapper.toDto(getExistingProducto(id));
    }

    @Transactional(readOnly = true)
    public Producto getExistingProducto(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto con: " + id + " no encontrado."));
    }

    @Transactional
    public ProductoDTO create(ProductoDTO productoDTO) {
        Producto newProducto = productoMapper.toEntity(productoDTO);
        return productoMapper.toDto(productoRepository.save(newProducto));
    }

    @Transactional
    public ProductoDTO update(Long id, ProductoDTO productoDTO) {
        Producto existingProducto = getExistingProducto(id);
        existingProducto.setNombre(productoDTO.nombre());
        existingProducto.setPresentacion(productoDTO.presentacion());
        existingProducto.setCategoria(productoDTO.categoria());
        existingProducto.setDisponible(productoDTO.disponible());
        return productoMapper.toDto(existingProducto);
    }

    @Transactional
    public void delete(Long id) {
        Producto existingProducto = getExistingProducto(id);
        productoRepository.delete(existingProducto);
    }
}
