package com.nuevo.spa.gestortareas.util.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TareaCambioDto {
    @Schema(example = "1")
    private Long id;
    @Schema(example = "Ordenar equipos sala este")
    @NotBlank(message = "Field nombre is required")
    @NotNull(message = "Field nombre cannot be null")
    private String nombre;
    @Schema(example = "Se deben ordenar los equipos por orden de envio")
    @NotBlank(message = "Field descripcion is required")
    @NotNull(message = "Field descripcion cannot be null")
    private String descripcion;
    @Schema(example = "Juan Oropeza")
    @NotBlank(message = "Field responsable is required")
    @NotNull(message = "Field responsable cannot be null")
    @Pattern(regexp = "^[^0-9]*$", message = "Field responsable cannot contain numbers")
    private String responsable;
    @Schema(example = "ejecutando")
    @NotBlank(message = "Field estado is required")
    @NotNull(message = "Field estado cannot be null")
    @Pattern(regexp = "^(iniciado|ejecutando|terminado)$", message = "Field estado must be a valid state")
    private String estado;
}
