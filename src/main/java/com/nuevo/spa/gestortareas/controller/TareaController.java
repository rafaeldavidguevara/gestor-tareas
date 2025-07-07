package com.nuevo.spa.gestortareas.controller;

import com.nuevo.spa.gestortareas.service.TareaService;
import com.nuevo.spa.gestortareas.util.dto.TareaCambioDto;
import com.nuevo.spa.gestortareas.util.dto.TareaDto;
import com.nuevo.spa.gestortareas.util.dto.TareaOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/tarea")
public class TareaController {
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping(value = "/obtenerTodas")
    public ResponseEntity<List<TareaOutputDto>> obtenerTareas() {
        return ResponseEntity.ok(tareaService.obtenerTareas());
    }

    @GetMapping(value = "/obtener/{tareaId}")
    public ResponseEntity<TareaOutputDto> obtenerTarea(@PathVariable("tareaId") Long id) {
        return ResponseEntity.ok(tareaService.obtenerTarea(id));
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<TareaOutputDto> crearTarea(@RequestBody TareaDto tareaNueva) {
        return ResponseEntity.ok(tareaService.crearTarea(tareaNueva));
    }

    @DeleteMapping(value = "/borrar/{tareaId}")
    public ResponseEntity<String> borrarTarea(@PathVariable("tareaId") Long id) {
        tareaService.borrarTarea(id);
        return ResponseEntity.ok("Tarea borrada exitosamente");
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<TareaOutputDto> actualizarTarea(@RequestBody TareaCambioDto tareaCambioDto) {
        return ResponseEntity.ok(tareaService.actualizarTarea(tareaCambioDto));
    }

    @PostMapping(value = "/actualizarVarias")
    public ResponseEntity<List<TareaOutputDto>> actualizarTareas(@RequestBody List<TareaCambioDto> tareaCambioDto) {
        return ResponseEntity.ok(tareaService.actualizarTareas(tareaCambioDto));
    }

}
