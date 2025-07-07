package com.nuevo.spa.gestortareas;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.repository.TareaRepository;
import com.nuevo.spa.gestortareas.service.TareaService;
import com.nuevo.spa.gestortareas.util.impl.TareaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class GestortareasApplication {

	private static final Logger log = LoggerFactory.getLogger(GestortareasApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GestortareasApplication.class, args);
		/*
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(GestortareasApplication.class, args);
		TareaRepository tareaRepository =
				configurableApplicationContext.getBean(TareaRepository.class);
		TareaFactory tareaFactory =
				configurableApplicationContext.getBean(TareaFactory.class);
		Tarea tarea = tareaFactory.createObject("Limpiar sala");
		tareaRepository.save(tarea);
		TareaService tareaService = configurableApplicationContext.getBean(TareaService.class);
		tareaService.crearTarea("Ordenar cajas en el almacén");
		tareaService.crearTarea("Limpiar estanteria");
		List<Tarea> tareas = tareaService.obtenerTareas();
		tareas.forEach(t -> {
			log.info("ID: " + t.getId().toString());
			log.info("Nombre:" + t.getNombre());
			log.info("Estado:" + t.getEstado().toString());
			log.info("Fecha de Creación:" + t.getFechaCreacion());
		});
		log.info(tareaService.obtenerTarea(2L).getNombre());
		tareaService.borrarTarea(2L);
		tareas = tareaService.obtenerTareas();
		tareas.forEach(t -> {
			log.info("ID: " + t.getId().toString());
			log.info("Nombre:" + t.getNombre());
			log.info("Estado:" + t.getEstado().toString());
			log.info("Fecha de Creación:" + t.getFechaCreacion());
		});
		Tarea tareaNueva = new Tarea("Asear estantería");
		tareaNueva.setId(3L);
		tareaNueva.setEstado(2L);
		tareaService.actualizarTarea(tareaNueva);
		log.info(tareaService.obtenerTarea(3L).getNombre());
		log.info(tareaService.obtenerTarea(3L).getEstado().toString());
		log.info(tareaService.obtenerTarea(3L).getFechaCreacion());
		 */
	}

}
