package com.nuevo.spa.gestortareas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class BeanConfiguration {

    @Bean
    public HashMap<String, Long> getEstados() {
        HashMap<String, Long> estados = new HashMap<>();
        estados.put("iniciado", 1L);
        estados.put("ejecutando", 2L);
        estados.put("terminado", 3L);
        return estados;
    }

}
