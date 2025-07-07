package com.nuevo.spa.gestortareas.util.impl;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.ObjectFactory;
import com.nuevo.spa.gestortareas.util.dto.TareaOutputDto;
import org.springframework.stereotype.Component;

@Component
public class TareaOutputDtoFactory implements ObjectFactory<TareaOutputDto, Tarea> {

    @Override
    public TareaOutputDto createObject(Tarea tarea) {
        TareaOutputDto tareaOutputDto = new TareaOutputDto();
        tareaOutputDto.setId(tarea.getId());
        tareaOutputDto.setNombre(tarea.getNombre());
        tareaOutputDto.setDescripcion(tarea.getDescripcion());
        tareaOutputDto.setResponsable(tarea.getResponsable());
        tareaOutputDto.setEstado(tarea.getEstado());
        tareaOutputDto.setFechaCreacion(tarea.getFechaCreacion());
        return tareaOutputDto;
    }
}
