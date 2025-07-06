package com.nuevo.spa.gestortareas.repository;

import com.nuevo.spa.gestortareas.model.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {
}
