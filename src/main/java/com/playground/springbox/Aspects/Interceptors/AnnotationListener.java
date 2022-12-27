package com.playground.springbox.Aspects.Interceptors;

import com.playground.springbox.Constants.AppConstants;
import com.playground.springbox.Models.Annotations.ExceptionHandler;
import com.playground.springbox.Models.Annotations.LogInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Slf4j
@SuppressWarnings(AppConstants.UNUSED)
@Component
@Aspect
public class AnnotationListener {
    
    public AnnotationListener() { }
    
    /**
     * Around advice provides a special parameter type to programmatically 'start' the methods' execution
     * at a place in time and surround the invocation with logic.
     */
    
    @Around("@annotation(com.playground.springbox.Models.Annotations.LogInfo)")
    public void logInfoAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LogInfo logInfo = method.getAnnotation(LogInfo.class);
        
        LOGGER.info(formatLogWithPoint(logInfo.onStart(), joinPoint));
        try {
            joinPoint.proceed();
            LOGGER.info(formatLogWithPoint(logInfo.onEnd(), joinPoint));
        } catch (Throwable exception) {
            LOGGER.error(formatLogWithPoint(logInfo.onError(), joinPoint), exception);
            throw exception;
        }
    }
    
    @Around("@annotation(com.playground.springbox.Models.Annotations.ExceptionHandler)")
    public void exceptionHandlerAdvice(ProceedingJoinPoint joinPoint) throws Exception {
        MethodSignature methodSignature = (MethodSignature)  joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ExceptionHandler exceptionHandler = method.getAnnotation(ExceptionHandler.class);
        
        try {
            joinPoint.proceed();
        } catch (Throwable exception) {
            Constructor<?> exceptionToThrow = exceptionHandler.value().getConstructor(String.class);
            throw (Exception) exceptionToThrow.newInstance(exception.getMessage());
        }
    }
    
    private String formatLogWithPoint(String logString, JoinPoint joinPoint) {
        return String.format(logString, joinPoint.getSignature().getName());
    }
}
