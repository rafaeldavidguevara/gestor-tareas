package com.nuevo.spa.gestortareas.util.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class TareaDto {
    @Schema(name = "Nombre tarea", example = "Ordenar equipos sala este")
    private String nombre;
    @Schema(name = "Descripcion tarea", example = "Se deben ordenar los equipos por orden de envio")
    private String descripcion;
    @Schema(name = "Responsable tarea", example = "Juan Oropeza")
    private String responsable;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
