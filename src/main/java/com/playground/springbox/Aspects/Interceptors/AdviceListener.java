package com.playground.springbox.Aspects.Interceptors;

import com.playground.springbox.Constants.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@SuppressWarnings(AppConstants.UNUSED)
@Component
@Aspect
public class AdviceListener {
    /**
     * Reference: https://www.baeldung.com/spring-aop-pointcut-tutorial
     * Syntax   : execution(CLASS_MODIFIER CLASS_PATH.CLASS_NAME.METHOD(TYPE)* supports '*' wild-card parameters,
     * Example  : execution(* com.foo.bar.Bar.method(Long))
     */
    public AdviceListener() {}

    // Additionally the PCD can also be described directly in the Advice
    @Before("execution(* com.playground.springbox.Controller.TestController.sanityCheck(..))")
    public void beforeSanityPoint(JoinPoint joinPoint) {
        LOGGER.info("Before :: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* com.playground.springbox.Controller.TestController.sanityCheck(..))")
    public void afterSanityPoint(JoinPoint joinPoint) {
        LOGGER.info("After :: {}", joinPoint.getSignature().getName());
    }
}
