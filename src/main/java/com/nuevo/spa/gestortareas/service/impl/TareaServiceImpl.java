package com.nuevo.spa.gestortareas.service.impl;

import com.nuevo.spa.gestortareas.exception.NotFoundException;
import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.repository.TareaRepository;
import com.nuevo.spa.gestortareas.service.TareaService;
import com.nuevo.spa.gestortareas.util.impl.TareaFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {
    private final TareaRepository tareaRepository;
    private final TareaFactory tareaFactory;

    public TareaServiceImpl(TareaRepository tareaRepository, TareaFactory tareaFactory) {
        this.tareaRepository = tareaRepository;
        this.tareaFactory = tareaFactory;
    }

    @Override
    public Tarea crearTarea(String nombre){
        return tareaRepository.save(tareaFactory.createObject(nombre));
    }

    @Override
    public List<Tarea> obtenerTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea obtenerTarea(Long id) {
        return tareaRepository.findById(id).orElseThrow(() -> new NotFoundException("Tarea no encontrada"));
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


}
