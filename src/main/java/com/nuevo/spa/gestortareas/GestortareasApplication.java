package com.nuevo.spa.gestortareas;

import com.nuevo.spa.gestortareas.estadotarea.infrastructure.entity.EstadoTareaEntity;
import com.nuevo.spa.gestortareas.estadotarea.infrastructure.repository.EstadoTareaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class GestortareasApplication {

	private static final Logger log = LoggerFactory.getLogger(GestortareasApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GestortareasApplication.class, args);

//		ConfigurableApplicationContext configurableApplicationContext =
//				SpringApplication.run(GestortareasApplication.class, args);
//
//		EstadoTareaRepository estadoTareaRepository =
//				configurableApplicationContext.getBean(EstadoTareaRepository.class);
//		EstadoTareaEntity estadoTarea1 = new EstadoTareaEntity();
//		EstadoTareaEntity estadoTarea2 = new EstadoTareaEntity();
//		EstadoTareaEntity estadoTarea3 = new EstadoTareaEntity();
//		estadoTarea1.setNombre("iniciado");
//		estadoTarea2.setNombre("ejecutando");
//		estadoTarea3.setNombre("terminado");
//		estadoTareaRepository.save(estadoTarea1);
//		estadoTareaRepository.save(estadoTarea2);
//		estadoTareaRepository.save(estadoTarea3);
	}

}
