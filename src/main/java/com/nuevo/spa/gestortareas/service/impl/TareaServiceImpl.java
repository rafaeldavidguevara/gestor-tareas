package com.nuevo.spa.gestortareas.service.impl;

import com.nuevo.spa.gestortareas.exception.NotFoundException;
import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.repository.EstadoTareaRepository;
import com.nuevo.spa.gestortareas.repository.TareaRepository;
import com.nuevo.spa.gestortareas.service.TareaService;
import com.nuevo.spa.gestortareas.util.dto.TareaCambioDto;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import com.nuevo.spa.gestortareas.util.dto.TareaOutputDto;
import com.nuevo.spa.gestortareas.util.helper.TareaHelper;
import com.nuevo.spa.gestortareas.util.impl.TareaFactory;
import com.nuevo.spa.gestortareas.util.impl.TareaOutputDtoFactory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TareaServiceImpl implements TareaService {
    private final TareaRepository tareaRepository;
    private final TareaFactory tareaFactory;
    private final TareaOutputDtoFactory tareaOutputDtoFactory;
    private final EstadoTareaRepository estadoTareaRepository;

    public TareaServiceImpl(TareaRepository tareaRepository,
                            TareaFactory tareaFactory,
                            TareaOutputDtoFactory tareaOutputDtoFactory,
                            EstadoTareaRepository estadoTareaRepository) {
        this.tareaRepository = tareaRepository;
        this.tareaFactory = tareaFactory;
        this.tareaOutputDtoFactory = tareaOutputDtoFactory;
        this.estadoTareaRepository = estadoTareaRepository;
    }

    @Override
    public TareaOutputDto crearTarea(TareaDto tareaDto){
        TareaOutputDto tareaOutputDto = tareaOutputDtoFactory.createObject(
                tareaRepository.save(tareaFactory.createObject(tareaDto)));
        tareaOutputDto.setEstado(estadoTareaRepository.findById(1L).get().getNombre());
        return tareaOutputDto;
    }

    @Override
    public List<TareaOutputDto> obtenerTareas() {
        return tareaRepository.findAll().stream().map(
                tarea -> {
                    TareaOutputDto tareaOutputDto = tareaOutputDtoFactory.createObject(tarea);
                    tareaOutputDto.setEstado(estadoTareaRepository.findById(tarea.getEstado()).get().getNombre());
                    return tareaOutputDto;
                }).collect(Collectors.toList());
    }

    @Override
    public TareaOutputDto obtenerTarea(Long id) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new NotFoundException("Tarea no encontrada"));
        TareaOutputDto tareaOutputDto = tareaOutputDtoFactory.createObject(tarea);
        tareaOutputDto.setEstado(estadoTareaRepository.findById(tarea.getEstado()).get().getNombre());
        return tareaOutputDto;
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
        Tarea tareaActual = tareaRepository.findById(Long.parseLong(tareaCambioDto.getId()))
                .orElseThrow(() -> new NotFoundException("Tarea no encontrada"));
        TareaOutputDto tareaOutputDto = tareaOutputDtoFactory.createObject(
                tareaRepository.save(TareaHelper.updateFields(tareaActual, tareaCambioDto)));
        tareaOutputDto.setEstado(estadoTareaRepository.findById(tareaActual.getEstado()).get().getNombre());
        return tareaOutputDto;
    }

    @Override
    public List<TareaOutputDto> actualizarTareas(List<TareaCambioDto> tareasNuevas) {
        return tareasNuevas.stream().map(t -> actualizarTarea(t)).collect(Collectors.toList());
    }

}
