package com.nuevo.spa.gestortareas.controller;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.service.TareaService;
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

    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTareas() {
        return ResponseEntity.ok(tareaService.obtenerTareas());
    }

    @GetMapping(value = "/{tareaId}")
    public ResponseEntity<TareaOutputDto> obtenerTarea(@PathVariable("tareaId") Long id) {
        return ResponseEntity.ok(tareaService.obtenerTarea(id));
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody TareaDto tareaNueva) {
        return ResponseEntity.ok(tareaService.crearTarea(tareaNueva));
    }

    @DeleteMapping(value = "/{tareaId}")
    public ResponseEntity<String> borrarTarea(@PathVariable("tareaId") Long id) {
        tareaService.borrarTarea(id);
        return ResponseEntity.ok("Tarea borrada exitosamente");
    }

    @PutMapping
    public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea tareaNueva) {
        return ResponseEntity.ok(tareaService.actualizarTarea(tareaNueva));
    }

    @PostMapping(value = "/actualizartareas")
    public ResponseEntity<List<Tarea>> actualizarTareas(@RequestBody List<Tarea> tareasNuevas) {
        return ResponseEntity.ok(tareaService.actualizarTareas(tareasNuevas));
    }


}
