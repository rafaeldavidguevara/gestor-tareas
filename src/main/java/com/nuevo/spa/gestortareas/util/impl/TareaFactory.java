package com.nuevo.spa.gestortareas.util.impl;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.ObjectFactory;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TareaFactory implements ObjectFactory<Tarea, TareaDto> {
    @Override
    public Tarea createObject(TareaDto tareaDto){
        //return  new Tarea(tareaDto.getNombre(), tareaDto.getDescripcion(), tareaDto.getResponsable());
        String fechaBuffer = LocalDateTime.now().toString();
        fechaBuffer = fechaBuffer.substring(0, fechaBuffer.indexOf("."));
        return Tarea.builder()
                .nombre(tareaDto.getNombre())
                .descripcion(tareaDto.getDescripcion())
                .responsable(tareaDto.getResponsable())
                .estado(1L)
                .fechaCreacion(fechaBuffer)
                .ultimaModificacion(fechaBuffer)
                .build();
    }
}
