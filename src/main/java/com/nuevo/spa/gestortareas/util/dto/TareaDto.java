package com.nuevo.spa.gestortareas.util.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TareaDto {
    @Schema(example = "Ordenar equipos sala este")
    private String nombre;
    @Schema(example = "Se deben ordenar los equipos por orden de envio")
    private String descripcion;
    @Schema(example = "Juan Oropeza")
    private String responsable;
}
