package com.nuevo.spa.gestortareas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String responsable;
    private Long estado;
    private String fechaCreacion;
    private String ultimaModificacion;
}
