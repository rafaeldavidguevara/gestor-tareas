package com.nuevo.spa.gestortareas.controller;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.service.TareaService;
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
    public ResponseEntity<Tarea> obtenerTarea(@PathVariable("tareaId") Long id) {
        return ResponseEntity.ok(tareaService.obtenerTarea(id));
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tareaNueva) {
        return ResponseEntity.ok(tareaService.crearTarea(tareaNueva.getNombre()));
    }

    @DeleteMapping(value = "/{tareaId}")
    public ResponseEntity<String> borrarTarea(@PathVariable("tareaId") Long id) {
        tareaService.borrarTarea(id);
        return ResponseEntity.ok("Tarea borrada exitosamente");
    }

    @PutMapping
    public ResponseEntity<Tarea> editarTarea(@RequestBody Tarea tareaNueva) {
        return ResponseEntity.ok(tareaService.actualizarTarea(tareaNueva));
    }


}
