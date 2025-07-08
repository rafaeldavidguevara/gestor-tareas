package com.nuevo.spa.gestortareas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestortareasApplication {

	private static final Logger log = LoggerFactory.getLogger(GestortareasApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GestortareasApplication.class, args);
	}

}
