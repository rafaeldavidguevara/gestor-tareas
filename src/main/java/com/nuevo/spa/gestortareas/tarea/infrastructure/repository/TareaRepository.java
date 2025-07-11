package com.nuevo.spa.gestortareas.tarea.infrastructure.repository;

import com.nuevo.spa.gestortareas.tarea.infrastructure.entity.TareaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends CrudRepository<TareaEntity, Long> {
    List<TareaEntity> findAll();
}
