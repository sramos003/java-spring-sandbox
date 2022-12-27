package com.playground.springbox.Annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionHandler {
    @AliasFor("exceptionToThrow")
    Class<? extends Exception> value() default com.playground.springbox.Exceptions.ApplicationException.class;
    
    @AliasFor("value")
    Class<? extends Exception> exceptionToThrow() default com.playground.springbox.Exceptions.ApplicationException.class;
}
