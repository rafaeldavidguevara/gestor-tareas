package com.nuevo.spa.gestortareas.service.impl;

import com.nuevo.spa.gestortareas.exception.NotFoundException;
import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.repository.TareaRepository;
import com.nuevo.spa.gestortareas.service.TareaService;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import com.nuevo.spa.gestortareas.util.dto.TareaOutputDto;
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

    public TareaServiceImpl(TareaRepository tareaRepository, TareaFactory tareaFactory, TareaOutputDtoFactory tareaOutputDtoFactory) {
        this.tareaRepository = tareaRepository;
        this.tareaFactory = tareaFactory;
        this.tareaOutputDtoFactory = tareaOutputDtoFactory;
    }

    @Override
    public Tarea crearTarea(TareaDto tareaDto){
        return tareaRepository.save(tareaFactory.createObject(tareaDto));
    }

    @Override
    public List<Tarea> obtenerTareas() {
        return tareaRepository.findAll();
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
    public Tarea actualizarTarea(Tarea tareaNueva) {
        Tarea tareaActual = tareaRepository.findById(tareaNueva.getId()).orElseThrow(() -> new NotFoundException("Tarea no encontrada"));
        tareaActual.setNombre(tareaNueva.getNombre());
        tareaActual.setEstado(tareaNueva.getEstado());
        tareaActual.setFechaCreacion(tareaNueva.getFechaCreacion());
        return tareaRepository.save(tareaActual);
    }

    @Override
    public List<Tarea> actualizarTareas(List<Tarea> tareasNuevas) {
        return tareasNuevas.stream().map( t -> tareaRepository.save(t)).collect(Collectors.toList());
    }

}
