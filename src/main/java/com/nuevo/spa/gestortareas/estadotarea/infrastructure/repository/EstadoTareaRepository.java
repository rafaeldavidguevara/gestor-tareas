package com.nuevo.spa.gestortareas.estadotarea.infrastructure.repository;

import com.nuevo.spa.gestortareas.estadotarea.infrastructure.entity.EstadoTareaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoTareaRepository extends CrudRepository<EstadoTareaEntity, Long> {
}
