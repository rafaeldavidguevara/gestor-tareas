package com.nuevo.spa.gestortareas.service;

import com.nuevo.spa.gestortareas.model.Tarea;

import java.util.List;

public interface TareaService {
    Tarea crearTarea(String nombre);
    List<Tarea> obtenerTareas();
    Tarea obtenerTarea(Long id);
    void borrarTarea(Long id);
    Tarea actualizarTarea(Tarea tareaNueva);
}
