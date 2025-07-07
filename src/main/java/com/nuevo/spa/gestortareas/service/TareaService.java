package com.nuevo.spa.gestortareas.service;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import com.nuevo.spa.gestortareas.util.dto.TareaOutputDto;

import java.util.List;

public interface TareaService {
    TareaOutputDto crearTarea(TareaDto tareaDto);
    List<TareaOutputDto> obtenerTareas();
    TareaOutputDto obtenerTarea(Long id);
    void borrarTarea(Long id);
    TareaOutputDto actualizarTarea(Tarea tareaNueva);
    List<TareaOutputDto> actualizarTareas(List<Tarea> tareasNuevas);
}
