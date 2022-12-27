package com.playground.springbox.Annotations;

import com.playground.springbox.Constants.AppConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ToDo:Known Issue Tracker.
 * 
 *  1) Does not propagate to nested private methods (execution PCD can be a work around for this)
 *   
 *  2) Current logic does 'ignore' the methods underlying calls, i.e 
 *     Method A calls Method B -> The call will complete but the PCD Aspect will 'proceed' with the logic before Method B completes. 
 *     No idea why (yet)
 */
@SuppressWarnings(AppConstants.UNUSED)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogInfo {
    String onStart() default AppConstants.ON_START_LOG; // Will only log if the 'debug' flag is set to true. Not to be mistaken with the slf4j DEBUG flag.
    String onEnd() default AppConstants.ON_END_LOG;
    String onError() default AppConstants.ON_ERROR_LOG;
    boolean debug() default false;
}
