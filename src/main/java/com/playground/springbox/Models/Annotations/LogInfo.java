package com.playground.springbox.Models.Annotations;

import com.playground.springbox.Constants.AppConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SuppressWarnings(AppConstants.UNUSED)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogInfo {
    String onStart() default AppConstants.ON_START_LOG; // Will only log if the 'debug' flag is set to true. Not to be mistaken with the slf4j DEBUG flag.
    String onEnd() default AppConstants.ON_END_LOG;
    String onError() default AppConstants.ON_ERROR_LOG;
    boolean debug() default false;
}
