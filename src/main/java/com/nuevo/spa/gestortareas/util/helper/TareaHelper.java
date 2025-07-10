package com.nuevo.spa.gestortareas.util.helper;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.dto.TareaCambioDto;

import java.util.HashMap;

public class TareaHelper {

    public static Tarea updateFields(Tarea tareaActual, TareaCambioDto tareaCambioDto) {
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
