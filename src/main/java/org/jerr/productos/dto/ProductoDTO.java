package org.jerr.productos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductoDTO (
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
    @NotBlank String nombre,
    @NotBlank String presentacion,
    @NotBlank String categoria,
    @NotNull Boolean disponible
)
{}
