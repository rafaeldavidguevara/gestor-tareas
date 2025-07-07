package com.nuevo.spa.gestortareas.repository;

import com.nuevo.spa.gestortareas.model.EstadoTarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoTareaRepository extends CrudRepository<EstadoTarea, Long> {
}
