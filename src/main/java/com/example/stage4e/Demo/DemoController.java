package com.example.stage4e.Demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demoController")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> SayHello(){
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}
