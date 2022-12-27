package com.playground.springbox.Exceptions;

import com.playground.springbox.Constants.AppConstants;

@SuppressWarnings(AppConstants.UNUSED)
public class ProxyException extends ApplicationException {
    
    public ProxyException(String exceptionMessage) {
        super(exceptionMessage);
    }
    
    public ProxyException(Exception exception) { 
        super(exception);
    }
}
