package com.inertia.solutions.apollo.item.mvc.aspect.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * Using JRE 1.7.0_75
 * 
 * The Interface LoggingAnnotation is a basic empty annotation
 * simply to provide a Pointcut template for a joinpoint advisor.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FineGrainLogging {

}

