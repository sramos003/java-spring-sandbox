package com.playground.springbox.Controller;

import com.playground.springbox.Constants.AppConstants;
import com.playground.springbox.Exceptions.ControllerException;
import com.playground.springbox.Models.Annotations.ExceptionHandler;
import com.playground.springbox.Service.IExampleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings(AppConstants.UNUSED)
@AllArgsConstructor
public class TestController {
    private final IExampleService exampleService;
    
    @GetMapping(value = "/health-check")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Hello World!");
    }
    
    @GetMapping(value = "/sanity-check")
    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<String> sanityCheck() throws Exception {
        exampleService.exampleException();
        return ResponseEntity.ok("Is user sane ::  " +  (Math.random() > 0.5) + " ");
    }
    
    @GetMapping("/logger-advice")
    public ResponseEntity<String> test() {
        exampleService.exampleVoid();
        return ResponseEntity.ok("Inside Test Method");
    }
}
