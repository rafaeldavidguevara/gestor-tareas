package com.nuevo.spa.gestortareas.tarea.infrastructure.util.factory;

import com.nuevo.spa.gestortareas.tarea.infrastructure.entity.TareaEntity;
import com.nuevo.spa.gestortareas.util.factory.ObjectFactory;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaDto;
import com.nuevo.spa.gestortareas.util.helper.TimestampHelper;
import org.springframework.stereotype.Component;

@Component
public class TareaFactory implements ObjectFactory<TareaEntity, TareaDto> {
    @Override
    public TareaEntity createObject(TareaDto tareaDto){
        String nowDate = TimestampHelper.getNowDate();
        return TareaEntity.builder()
                .nombre(tareaDto.getNombre())
                .descripcion(tareaDto.getDescripcion())
                .responsable(tareaDto.getResponsable())
                .estado(1L)
                .fechaCreacion(nowDate)
                .ultimaModificacion(nowDate)
                .build();
    }
}
