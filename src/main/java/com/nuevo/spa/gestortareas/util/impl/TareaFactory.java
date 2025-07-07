package com.nuevo.spa.gestortareas.util.impl;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.ObjectFactory;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import org.springframework.stereotype.Component;

@Component
public class TareaFactory implements ObjectFactory<Tarea, TareaDto> {
    @Override
    public Tarea createObject(TareaDto tareaDto){
        return  new Tarea(tareaDto.getNombre(), tareaDto.getDescripcion(), tareaDto.getResponsable());
    }
}
