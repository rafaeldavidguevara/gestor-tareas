package com.nuevo.spa.gestortareas.util.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TareaCambioDto {
    @Schema(example = "1")
    private Long id;
    @Schema(example = "Ordenar equipos sala este")
    private String nombre;
    @Schema(example = "Se deben ordenar los equipos por orden de envio")
    private String descripcion;
    @Schema(example = "Juan Oropeza")
    private String responsable;
    @Schema(example = "ejecutando")
    private String estado;
}
