package com.nuevo.spa.gestortareas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "estados_tarea")
public class EstadoTarea {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String nombre;
}
