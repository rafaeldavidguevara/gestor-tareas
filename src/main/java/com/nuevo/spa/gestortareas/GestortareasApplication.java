package com.nuevo.spa.gestortareas;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.repository.TareaRepository;
import com.nuevo.spa.gestortareas.util.impl.TareaFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GestortareasApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(GestortareasApplication.class, args);
		TareaRepository tareaRepository =
				configurableApplicationContext.getBean(TareaRepository.class);
		TareaFactory tareaFactory =
				configurableApplicationContext.getBean(TareaFactory.class);
		Tarea tarea = tareaFactory.createObject("Limpiar sala");
		tareaRepository.save(tarea);
	}

}
