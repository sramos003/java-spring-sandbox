package com.playground.springbox.Service.Impl;

import com.playground.springbox.Constants.AppConstants;
import com.playground.springbox.Exceptions.GeneralApplicationException;
import com.playground.springbox.Models.Annotations.ExceptionHandler;
import com.playground.springbox.Models.Annotations.LogInfo;
import com.playground.springbox.Service.IExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@SuppressWarnings(AppConstants.UNUSED)
public class ExampleServiceImpl implements IExampleService {
    ExampleServiceImpl() { }
    
    @LogInfo
    @Override
    public void exampleVoid() {
        LOGGER.info("Inside ExampleServiceImpl");
    }
    
    @Override
    @LogInfo(debug = true, onStart = "Expecting method to throw an exception")
    @ExceptionHandler(GeneralApplicationException.class)
    public void exampleException() throws Exception {
        throw new Exception("error");
    }
}
