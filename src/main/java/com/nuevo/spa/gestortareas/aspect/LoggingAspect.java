package com.nuevo.spa.gestortareas.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.nuevo.spa.gestortareas.controller..*.*(..))")
    public void logBeforeExecuteEndpoint(JoinPoint joinPoint) {
        logger.info("Method execution started: {} {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.nuevo.spa.gestortareas.controller..*.*(..))")
    public void logAfterExecuteEndpoint(JoinPoint joinPoint) {
        logger.info("Method execution completed: {}", joinPoint.getSignature().getName());
    }
}