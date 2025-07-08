package com.nuevo.spa.gestortareas.util.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TareaOutputDto {
    @Schema(example = "1")
    private Long id;
    @Schema(example = "Ordenar equipos sala este")
    private String nombre;
    @Schema(example = "Se deben ordenar los equipos por orden de envio")
    private String descripcion;
    @Schema(example = "Juan Oropeza")
    private String responsable;
    @Schema(example = "iniciado")
    private String estado;
    @Schema(example = "2025-07-07T12:23:03")
    private String fechaCreacion;
    @Schema(example = "2025-07-07T12:23:03")
    private String ultimaModificacion;
}
