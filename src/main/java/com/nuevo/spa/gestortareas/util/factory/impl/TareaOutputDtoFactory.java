package com.nuevo.spa.gestortareas.util.factory.impl;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.factory.ObjectFactory;
import com.nuevo.spa.gestortareas.util.dto.TareaOutputDto;
import org.springframework.stereotype.Component;

@Component
public class TareaOutputDtoFactory implements ObjectFactory<TareaOutputDto, Tarea> {

    @Override
    public TareaOutputDto createObject(Tarea tarea) {
        return TareaOutputDto.builder()
                .id(tarea.getId().toString())
                .nombre(tarea.getNombre())
                .descripcion(tarea.getDescripcion())
                .responsable(tarea.getResponsable())
                .fechaCreacion(tarea.getFechaCreacion())
                .ultimaModificacion(tarea.getUltimaModificacion())
                .build();
    }

}
