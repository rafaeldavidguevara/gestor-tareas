package com.nuevo.spa.gestortareas.tarea.infrastructure.util.helper;

import com.nuevo.spa.gestortareas.tarea.infrastructure.entity.TareaEntity;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaCambioDto;
import com.nuevo.spa.gestortareas.util.helper.TimestampHelper;

import java.util.HashMap;

public class TareaHelper {

    public static TareaEntity updateFields(TareaEntity tareaActual, TareaCambioDto tareaCambioDto) {
        HashMap<String, Long> estados = new HashMap<>();
        estados.put("iniciado", 1L);
        estados.put("ejecutando", 2L);
        estados.put("terminado", 3L);
        tareaActual.setNombre(tareaCambioDto.getNombre());
        tareaActual.setEstado(estados.get(tareaCambioDto.getEstado()));
        tareaActual.setUltimaModificacion(TimestampHelper.getNowDate());
        tareaActual.setResponsable(tareaCambioDto.getResponsable());
        tareaActual.setDescripcion(tareaCambioDto.getDescripcion());
        return tareaActual;
    }

}
