package com.nuevo.spa.gestortareas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Long estado;
    private String fechaCreacion;

    public Tarea() {
    }

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.estado = 1L;
        this.fechaCreacion = LocalDate.now().toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public Long getId() {
        return id;
    }
}
