package com.playground.springbox.Exceptions;

import com.playground.springbox.Constants.AppConstants;

@SuppressWarnings(AppConstants.UNUSED)
public class GeneralApplicationException extends ApplicationException {
    
    public GeneralApplicationException(String exceptionMessage) {
        super(exceptionMessage);
    }
    
    public GeneralApplicationException(Exception exception) {
        super(exception);
    }
}
