package com.example.Ejericio456;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    @GetMapping("/saludo")
    public  String saludar(){
        return "Hello";

    }
}
