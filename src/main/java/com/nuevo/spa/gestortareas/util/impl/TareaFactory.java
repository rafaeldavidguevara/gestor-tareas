package com.nuevo.spa.gestortareas.util.impl;

import com.nuevo.spa.gestortareas.model.Tarea;
import com.nuevo.spa.gestortareas.util.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class TareaFactory implements ObjectFactory<Tarea> {
    @Override
    public Tarea createObject(String name){
        return  new Tarea(name);
    }
}
