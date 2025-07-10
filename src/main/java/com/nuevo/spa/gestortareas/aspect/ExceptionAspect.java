package com.nuevo.spa.gestortareas.aspect;

import com.nuevo.spa.gestortareas.exception.NotFoundException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

@Aspect
@Component
public class ExceptionAspect {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @AfterThrowing(pointcut = "execution(* com.nuevo.spa.gestortareas.service.impl..*.*(..))", throwing = "ex")
    public void handleServiceExceptions(Exception ex) {
        if (ex instanceof NoSuchElementException nseEx) {
            logger.error("NoSuchElementException occurred: {}", nseEx.getMessage());
            throw new NotFoundException("Tarea no encontrada");
        } else {
            logger.error("Exception occurred: {}", ex.getMessage());
        }
    }
}
