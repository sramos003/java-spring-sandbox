package com.playground.springbox.Annotations;

import com.playground.springbox.Constants.AppConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SuppressWarnings(AppConstants.UNUSED)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AuditLogger {
    // Ideally this should be empty, maybe with flag or two
}
