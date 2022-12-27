package com.playground.springbox.Service;

import com.playground.springbox.Constants.AppConstants;

@SuppressWarnings(AppConstants.UNUSED)
public interface IExampleService {
    
    void exampleVoid();
    
    Integer exampleFib(int nthElement);
    
    void exampleException() throws Exception;
}
