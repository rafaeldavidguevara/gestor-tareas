package com.nuevo.spa.gestortareas.util.impl;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.ObjectFactory;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import com.nuevo.spa.gestortareas.util.helper.TimestampHelper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TareaFactory implements ObjectFactory<Tarea, TareaDto> {
    @Override
    public Tarea createObject(TareaDto tareaDto){
        String nowDate = TimestampHelper.getNowDate();
        return Tarea.builder()
                .nombre(tareaDto.getNombre())
                .descripcion(tareaDto.getDescripcion())
                .responsable(tareaDto.getResponsable())
                .estado(1L)
                .fechaCreacion(nowDate)
                .ultimaModificacion(nowDate)
                .build();
    }
}
