package com.playground.springbox.Service.Impl;

import com.playground.springbox.Constants.AppConstants;
import com.playground.springbox.Service.IExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
@SuppressWarnings(AppConstants.UNUSED)
public class ExampleServiceImpl implements IExampleService {
    ExampleServiceImpl() { }
    final int ZERO = 0, ONE = 1, TWO = 2;
    
    // Arbitrarily rebuilt on every invocation to track time to complete.
    ArrayList<Integer> fibonacciSequence = new ArrayList<>();
    
    @Override
    public void exampleVoid() {
        LOGGER.info("Inside ExampleServiceImpl");
    }
    
    @Override
    public Integer exampleFib(int nthElement) {
        fibonacciSequence.clear();
        buildFibonacciSequence(nthElement + ONE);
        return fibonacciSequence.get(nthElement);
    }
    
    private void buildFibonacciSequence(int limit) {
        // Add starting values to build Fibonacci Sequence with
        if (fibonacciSequence.isEmpty()) {
            fibonacciSequence.add(ZERO);
            fibonacciSequence.add(ONE);
        }
        
        Integer secondToLastValue = fibonacciSequence.get(fibonacciSequence.size() - TWO);
        Integer lastValue = fibonacciSequence.get(fibonacciSequence.size() - ONE);
        fibonacciSequence.add(secondToLastValue + lastValue);
        
        // If the cache size is still not at the nthElement limit, call this method again to add to the fib cache.
        if (fibonacciSequence.size() < limit) {
            buildFibonacciSequence(limit);
        }
    }
    
    @Override
    public void exampleException() throws Exception {
        throw new Exception("error");
    }
}
