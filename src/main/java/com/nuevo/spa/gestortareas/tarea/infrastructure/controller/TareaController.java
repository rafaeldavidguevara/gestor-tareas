package com.nuevo.spa.gestortareas.tarea.infrastructure.controller;

import com.nuevo.spa.gestortareas.tarea.application.TareaService;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaCambioDto;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaDto;
import com.nuevo.spa.gestortareas.tarea.infrastructure.dto.TareaOutputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarea")
@Tag(name = "API de Tareas")
public class TareaController {
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @Operation(summary = "Mostrar todas las tareas", description = "Retorna una lista con todas las tareas en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tareas mostradas exitosamente")
    })
    @GetMapping(value = "/obtenerTodas", produces = { "application/json" })
    public ResponseEntity<List<TareaOutputDto>> obtenerTareas() {
        return ResponseEntity.ok(tareaService.obtenerTareas());
    }

    @Operation(summary = "Mostrar una tarea dado su id", description = "Retorna una tarea en el sistema dado un id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarea mostrada exitosamente")
    })
    @GetMapping(value = "/obtener/{tareaId}", produces = { "application/json" })
    public ResponseEntity<TareaOutputDto> obtenerTarea(@PathVariable("tareaId") Long id) {
        return ResponseEntity.ok(tareaService.obtenerTarea(id));
    }

    @Operation(summary = "Crear una tarea nueva", description = "Retorna una tarea nueva y la almacena en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarea creada exitosamente")
    })
    @PostMapping(value = "/crear",produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<TareaOutputDto> crearTarea(@Valid @RequestBody TareaDto tareaNueva) {
        return ResponseEntity.ok(tareaService.crearTarea(tareaNueva));
    }

    @Operation(summary = "Borrar una tarea del sistema dado su id", description = "Elimina una tarea en el sistema dado un id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarea borrada exitosamente")
    })
    @DeleteMapping(value = "/borrar/{tareaId}")
    public ResponseEntity<String> borrarTarea(@PathVariable("tareaId") Long id) {
        tareaService.borrarTarea(id);
        return ResponseEntity.ok("Tarea borrada exitosamente");
    }

    @Operation(summary = "Actualizar una tarea", description = "Actualiza una tarea en el sistema a partir de otra tarea")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarea actualizada exitosamente")
    })
    @PutMapping(value = "/actualizar", produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<TareaOutputDto> actualizarTarea(@Valid @RequestBody TareaCambioDto tareaCambioDto) {
        return ResponseEntity.ok(tareaService.actualizarTarea(tareaCambioDto));
    }

    @Operation(summary = "Actualizar varias tareas", description = "Actualiza varias tarea en el sistema a partir de un listado de tareas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tareas actualizadas exitosamente")
    })
    @PostMapping(value = "/actualizarVarias", produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<List<TareaOutputDto>> actualizarTareas(@RequestBody List<@Valid TareaCambioDto> tareaCambioDto) {
        return ResponseEntity.ok(tareaService.actualizarTareas(tareaCambioDto));
    }

}
