package com.nuevo.spa.gestortareas.util.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class TareaCambioDto {
    @Schema(name = "ID tarea", example = "1")
    private Long id;
    @Schema(name = "Nombre tarea", example = "Ordenar equipos sala este")
    private String nombre;
    @Schema(name = "Descripcion tarea", example = "Se deben ordenar los equipos por orden de envio")
    private String descripcion;
    @Schema(name = "Responsable tarea", example = "Juan Oropeza")
    private String responsable;
    @Schema(name = "Estado tarea", example = "2")
    private Long estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
}
