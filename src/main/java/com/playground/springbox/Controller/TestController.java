package com.playground.springbox.Controller;

import com.playground.springbox.Constants.AppConstants;
import com.playground.springbox.Exceptions.ControllerException;
import com.playground.springbox.Annotations.ExceptionHandler;
import com.playground.springbox.Service.IExampleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings(AppConstants.UNUSED)
@AllArgsConstructor
@Slf4j
public class TestController {
    private final IExampleService exampleService;
    
    @GetMapping(value = "/health-check")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Hello World!");
    }
    
    @GetMapping(value = "/sanity-check")
    public ResponseEntity<String> sanityCheck() throws Exception {
        exampleService.exampleException();
        return ResponseEntity.ok("Is user sane ::  " +  (Math.random() > 0.5) + " ");
    }
    
    @GetMapping("/logger-advice")
    public ResponseEntity<String> test() {
        exampleService.exampleVoid();
        return ResponseEntity.ok("Inside Test Method");
    }
    
    
    @GetMapping("/fib-test")
    public ResponseEntity<String> getFibonacciElementAtIndex(int nthElementToFind) {
        if (nthElementToFind == 0) {
            final int FIFTY = 50;
            nthElementToFind = (int) (Math.random() * FIFTY);
            LOGGER.info("Element to find was passed as '0'. generated random element position to find of {}", nthElementToFind);
        }
        String responseString = String.format(
                "The associated Fibonacci value at position (%s) is (%s)",
                nthElementToFind,
                exampleService.exampleFib(nthElementToFind)
        );
        return ResponseEntity.ok(responseString);
    }
}
