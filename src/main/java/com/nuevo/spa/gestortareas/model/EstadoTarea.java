package com.nuevo.spa.gestortareas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estados_tarea")
public class EstadoTarea {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String nombre;

    public EstadoTarea() {
    }

    public EstadoTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
