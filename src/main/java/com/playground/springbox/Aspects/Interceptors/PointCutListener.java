package com.playground.springbox.Aspects.Interceptors;

import com.playground.springbox.Constants.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@SuppressWarnings(AppConstants.UNUSED)
@Component
@Aspect
public class PointCutListener {
    /**
     * Reference: https://www.baeldung.com/spring-aop-pointcut-tutorial
     * Syntax   : execution(CLASS_MODIFIER CLASS_PATH.CLASS_NAME.METHOD(TYPE)* supports '*' wild-card parameters,
     * Example  : execution(* com.foo.bar.Bar.method(Long))
     */
    public PointCutListener() { }

    // The PCD can be described as a standalone method to bind different Advices around it
    @Pointcut("execution(* com.playground.springbox.Controller.TestController.healthCheck(..))")
    public void controllerPointCut() { }

    @Before("controllerPointCut()")
    public void beforeControllerPoint(JoinPoint joinPoint) {
        LOGGER.info("Before aspect :: {}", joinPoint.getSignature().getName());
    }

    @After("controllerPointCut()")
    public void afterControllerPoint(JoinPoint joinPoint) {
        LOGGER.info("After aspect :: {}", joinPoint.getSignature().getName());
    }
}
