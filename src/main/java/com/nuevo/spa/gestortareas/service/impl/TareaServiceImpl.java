package com.nuevo.spa.gestortareas.service.impl;

import com.nuevo.spa.gestortareas.exception.NotFoundException;
import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.repository.TareaRepository;
import com.nuevo.spa.gestortareas.service.TareaService;
import com.nuevo.spa.gestortareas.util.dto.TareaCambioDto;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import com.nuevo.spa.gestortareas.util.dto.TareaOutputDto;
import com.nuevo.spa.gestortareas.util.impl.TareaFactory;
import com.nuevo.spa.gestortareas.util.impl.TareaOutputDtoFactory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TareaServiceImpl implements TareaService {
    private final TareaRepository tareaRepository;
    private final TareaFactory tareaFactory;
    private final TareaOutputDtoFactory tareaOutputDtoFactory;

    public TareaServiceImpl(TareaRepository tareaRepository, TareaFactory tareaFactory, TareaOutputDtoFactory tareaOutputDtoFactory) {
        this.tareaRepository = tareaRepository;
        this.tareaFactory = tareaFactory;
        this.tareaOutputDtoFactory = tareaOutputDtoFactory;
    }

    @Override
    public TareaOutputDto crearTarea(TareaDto tareaDto){
        return tareaOutputDtoFactory.createObject(tareaRepository.save(tareaFactory.createObject(tareaDto)));
    }

    @Override
    public List<TareaOutputDto> obtenerTareas() {
        return tareaRepository.findAll().stream().map(
                tarea -> tareaOutputDtoFactory.createObject(tarea)).collect(Collectors.toList());
    }

    @Override
    public TareaOutputDto obtenerTarea(Long id) {
        return tareaOutputDtoFactory.createObject(
                tareaRepository.findById(id).orElseThrow(() -> new NotFoundException("Tarea no encontrada")));
    }

    @Override
    public void borrarTarea(Long id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
        }else {
            throw new NotFoundException("Tarea no encontrada");
        }
    }

   @Override
    public TareaOutputDto actualizarTarea(TareaCambioDto tareaCambioDto) {
        Tarea tareaActual = tareaRepository.findById(tareaCambioDto.getId()).orElseThrow(() -> new NotFoundException("Tarea no encontrada"));
        tareaActual.setNombre(tareaCambioDto.getNombre());
        tareaActual.setEstado(tareaCambioDto.getEstado());
        String fechaBuffer = LocalDateTime.now().toString();
        tareaActual.setUltimaModificacion(fechaBuffer.substring(0, fechaBuffer.indexOf(".")));
        tareaActual.setResponsable(tareaCambioDto.getResponsable());
        tareaActual.setDescripcion(tareaCambioDto.getDescripcion());
        return tareaOutputDtoFactory.createObject(tareaRepository.save(tareaActual));
    }

    @Override
    public List<TareaOutputDto> actualizarTareas(List<TareaCambioDto> tareasNuevas) {
        return tareasNuevas.stream().map(
                t -> actualizarTarea(t)).collect(Collectors.toList());
    }

}
