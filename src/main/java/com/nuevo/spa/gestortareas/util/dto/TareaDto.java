package com.nuevo.spa.gestortareas.util.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class TareaDto {
    @Schema(example = "Ordenar equipos sala este")
    @NotBlank(message = "Field name is required")
    @NotNull(message = "Field name cannot be null")
    private String nombre;
    @Schema(example = "Se deben ordenar los equipos por orden de envio")
    @NotBlank(message = "Field description is required")
    @NotNull(message = "Field description cannot be null")
    private String descripcion;
    @Schema(example = "Juan Oropeza")
    @NotBlank(message = "Field responsable is required")
    @NotNull(message = "Field responsable cannot be null")
    @Pattern(regexp = "^[^0-9]*$", message = "Field responsable cannot contain numbers")
    private String responsable;
}
