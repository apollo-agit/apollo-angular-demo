/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * Using JRE 1.7.0_75
 * 
 * The Interface LoggingAspect is provided the aspect interface which provides the 
 * join for any function or exception "pointcut". 
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
public interface LoggingAspect {

	/**
	 * Log before any joinpoint execution. This is typically a class function,
	 * but could be another aspect advisor as well. The implementation will provide any
	 * advice.
	 *
	 * @param joinPoint the join point (descibed by the pointcut)
	 */
	public void logBefore(JoinPoint joinPoint);

	/**
	 * Log after joinpoint execution.
	 *
	 * @param joinPoint the join point (descibed by the pointcut)
	 */
	public void logAfter(JoinPoint joinPoint);

	/**
	 * Log after throwing exception joined by the Pointcut expression.
	 *
	 * @param joinPoint the join point
	 * @param e the e
	 */
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e);

	/**
	 * Log before annotation this a joinput that will log before anything anotated with 
	 * out pointcut annotation. This is for specific debug logging.
	 *
	 * @param joinPoint the join point
	 */
	public void logBeforeAnnotation(JoinPoint joinPoint);
	
}