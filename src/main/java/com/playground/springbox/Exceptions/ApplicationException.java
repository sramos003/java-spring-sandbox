package com.playground.springbox.Exceptions;

import com.playground.springbox.Constants.AppConstants;

@SuppressWarnings(AppConstants.UNUSED)
public class ApplicationException extends Exception {
    String item;
    
    public ApplicationException(String exceptionMessage) {
        super(exceptionMessage);
        this.item = exceptionMessage;
    }
    
    public ApplicationException(Exception exception) {
        super(exception);
        this.item = exception.getMessage();
    }
}
