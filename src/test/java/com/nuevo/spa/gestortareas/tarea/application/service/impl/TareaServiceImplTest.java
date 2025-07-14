package com.nuevo.spa.gestortareas.tarea.application.service.impl;

import com.nuevo.spa.gestortareas.estadotarea.infrastructure.entity.EstadoTareaEntity;
import com.nuevo.spa.gestortareas.estadotarea.infrastructure.repository.EstadoTareaRepository;
import com.nuevo.spa.gestortareas.exception.NotFoundException;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaCambioDto;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaDto;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaOutputDto;
import com.nuevo.spa.gestortareas.tarea.infrastructure.entity.TareaEntity;
import com.nuevo.spa.gestortareas.tarea.infrastructure.repository.TareaRepository;
import com.nuevo.spa.gestortareas.tarea.infrastructure.util.factory.TareaFactory;
import com.nuevo.spa.gestortareas.tarea.infrastructure.util.factory.TareaOutputDtoFactory;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TareaServiceImplTest {
    @Mock
    private TareaRepository tareaRepository;
    @Mock
    private TareaFactory tareaFactory;
    @Mock
    private TareaOutputDtoFactory tareaOutputDtoFactory;
    @Mock
    private EstadoTareaRepository estadoTareaRepository;
    @InjectMocks
    private TareaServiceImpl tareaService;

    @Test
    public void givenTareaDto_whenCallCrearTareaMethod_thenReturnNotNullTareaOutputDtoWithExpectedFields() {
        // GIVEN
        TareaDto tareaDto =  TareaDto.builder()
                .nombre("Tarea de prueba")
                .descripcion("Descripción de la tarea de prueba")
                .responsable("Antonio Perez")
                .build();
        TareaOutputDto tareaOutputDto = TareaOutputDto.builder()
                .id("1")
                .nombre(tareaDto.getNombre())
                .descripcion(tareaDto.getDescripcion())
                .responsable(tareaDto.getResponsable())
                .estado("iniciado")
                .build();
        Mockito.when(tareaOutputDtoFactory.createObject(any())).thenReturn(tareaOutputDto);
        Mockito.when(estadoTareaRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(
                    EstadoTareaEntity.builder()
                            .id(1L)
                            .nombre("iniciado")
                            .build()));
        // WHEN
        TareaOutputDto tOutputDto = tareaService.crearTarea(tareaDto);
        // THEN
        Assert.notNull(tOutputDto);
        Assert.isTrue(tOutputDto.getNombre().equals(tareaDto.getNombre()), "El nombre de la tarea no coincide");
        Assert.isTrue(tOutputDto.getDescripcion().equals(tareaDto.getDescripcion()), "La descripción de la tarea no coincide");
        Assert.isTrue(tOutputDto.getResponsable().equals(tareaDto.getResponsable()), "El responsable de la tarea no coincide");
        Assert.isTrue(tOutputDto.getEstado().equals("iniciado"), "El estado de la tarea no es 'iniciado'");
    }

    @Test
    public void givenTareaDto_whenCallObtenerTareasMethod_thenReturnNotNullListOfTareaOutputDto() {
        // GIVEN
        TareaOutputDto tareaOutputDto = TareaOutputDto.builder()
                .id("1")
                .nombre("Tarea de prueba")
                .descripcion("Descripción de la tarea de prueba")
                .responsable("Antonio Perez")
                .estado("iniciado")
                .build();
        List<TareaEntity> tareaEntityList = java.util.List.of(
                TareaEntity.builder()
                        .id(1L)
                        .nombre("Tarea de prueba")
                        .descripcion("Descripción de la tarea de prueba")
                        .responsable("Antonio Perez")
                        .estado(1L)
                        .build()
        );
        Mockito.when(tareaRepository.findAll()).thenReturn(tareaEntityList);
        Mockito.when(tareaOutputDtoFactory.createObject(any())).thenReturn(tareaOutputDto);
        Mockito.when(estadoTareaRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(
                    EstadoTareaEntity.builder()
                            .id(1L)
                            .nombre("iniciado")
                            .build()));
        // WHEN
        java.util.List<TareaOutputDto> tOutputDtos = tareaService.obtenerTareas();
        // THEN
        Assert.notNull(tOutputDtos);
        Assert.isTrue(tOutputDtos.size() == 1, "La lista de tareas no contiene un único elemento");
    }

    @Test
    public void givenTareaId_whenCallObtenerTareaMethod_thenReturnNotNullTareaOutputDto() {
        // GIVEN
        Long tareaId = 1L;
        TareaEntity tareaEntity = TareaEntity.builder()
                .id(tareaId)
                .nombre("Tarea de prueba")
                .descripcion("Descripción de la tarea de prueba")
                .responsable("Antonio Perez")
                .estado(1L)
                .build();
        TareaOutputDto tareaOutputDto = TareaOutputDto.builder()
                .id(tareaId.toString())
                .nombre(tareaEntity.getNombre())
                .descripcion(tareaEntity.getDescripcion())
                .responsable(tareaEntity.getResponsable())
                .estado("iniciado")
                .build();
        Mockito.when(tareaRepository.findById(tareaId)).thenReturn(java.util.Optional.ofNullable(tareaEntity));
        Mockito.when(tareaOutputDtoFactory.createObject(any())).thenReturn(tareaOutputDto);
        Mockito.when(estadoTareaRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(
                    EstadoTareaEntity.builder()
                            .id(1L)
                            .nombre("iniciado")
                            .build()));
        // WHEN
        TareaOutputDto tOutputDto = tareaService.obtenerTarea(tareaId);
        // THEN
        Assert.notNull(tOutputDto);
        Assert.isTrue(tOutputDto.getId().equals(tareaId.toString()), "El id de la tarea no coincide");
    }

    @Test
    public void givenTareaId_whenCallBorrarTareaMethod_thenTareaIsDeleted() {
        // GIVEN
        Long tareaId = 1L;
        Mockito.when(tareaRepository.existsById(tareaId)).thenReturn(true);
        // WHEN
        tareaService.borrarTarea(tareaId);
        // THEN
        Mockito.verify(tareaRepository, Mockito.times(1)).deleteById(tareaId);
    }

    @Test
    public void givenTareaId_whenCallBorrarTareaMethod_thenThrowException() {
        // GIVEN
        Long tareaId = 1L;
        Mockito.when(tareaRepository.existsById(tareaId)).thenReturn(false);
        // WHEN & THEN
        assertThrows(NotFoundException.class, () -> {
            tareaService.borrarTarea(tareaId);
        });
    }

    @Test
    public void givenTareaCambioDto_whenCallActualizarTareaMethod_thenReturnNotNullTareaOutputDtoWithChangedField() {
        // GIVEN
        TareaEntity tareaEntity = TareaEntity.builder()
                .id(1L)
                .nombre("Tarea de prueba")
                .descripcion("Descripción de la tarea de prueba")
                .responsable("Antonio Perez")
                .estado(1L)
                .build();
        TareaOutputDto tareaOutputDto = TareaOutputDto.builder()
                .id("1")
                .nombre("Nueva Tarea")
                .descripcion(tareaEntity.getDescripcion())
                .responsable(tareaEntity.getResponsable())
                .estado("iniciado")
                .build();
        Mockito.when(tareaRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(tareaEntity));
        Mockito.when(tareaOutputDtoFactory.createObject(any())).thenReturn(tareaOutputDto);
        Mockito.when(estadoTareaRepository.findById(any()))
                .thenReturn(java.util.Optional.ofNullable(
                    EstadoTareaEntity.builder()
                            .id(1L)
                            .nombre("iniciado")
                            .build()));
        // WHEN
        TareaOutputDto tOutputDto = tareaService.actualizarTarea(
                TareaCambioDto.builder()
                        .id("1")
                        .nombre("Nueva Tarea")
                        .descripcion("Nueva Descripción")
                        .responsable("Nuevo Responsable")
                        .estado("iniciado")
                        .build()
        );
        // THEN
        Assert.notNull(tOutputDto);
        Assert.isTrue(tOutputDto.getNombre().equals("Nueva Tarea"), "El nombre de la tarea no coincide");
    }

}