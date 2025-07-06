package com.nuevo.spa.gestortareas.service.impl;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.repository.TareaRepository;
import com.nuevo.spa.gestortareas.service.TareaService;
import com.nuevo.spa.gestortareas.util.impl.TareaFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Tarea> tareaOpt = tareaRepository.findById(id);
        if (tareaOpt.isPresent()) {
            return tareaOpt.get();
        }else {
            throw new RuntimeException("Tarea no encontrada");
        }
    }


}
