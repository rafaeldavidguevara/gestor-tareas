package com.nuevo.spa.gestortareas.service;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import com.nuevo.spa.gestortareas.util.dto.TareaOutputDto;

import java.util.List;

public interface TareaService {
    Tarea crearTarea(TareaDto tareaDto);
    List<Tarea> obtenerTareas();
    TareaOutputDto obtenerTarea(Long id);
    void borrarTarea(Long id);
    Tarea actualizarTarea(Tarea tareaNueva);
    List<Tarea> actualizarTareas(List<Tarea> tareasNuevas);
}
