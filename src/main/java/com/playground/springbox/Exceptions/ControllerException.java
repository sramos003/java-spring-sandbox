package com.playground.springbox.Exceptions;

import com.playground.springbox.Constants.AppConstants;

@SuppressWarnings(AppConstants.UNUSED)
public class ControllerException extends ApplicationException {
    
    public ControllerException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public ControllerException(Exception exception) {
        super(exception);
    }
}
