package com.nuevo.spa.gestortareas.tarea.infrastructure.util.factory;

import com.nuevo.spa.gestortareas.tarea.infrastructure.entity.TareaEntity;
import com.nuevo.spa.gestortareas.util.factory.ObjectFactory;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaOutputDto;
import org.springframework.stereotype.Component;

@Component
public class TareaOutputDtoFactory implements ObjectFactory<TareaOutputDto, TareaEntity> {

    @Override
    public TareaOutputDto createObject(TareaEntity tarea) {
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
