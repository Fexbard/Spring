package com.example.Ejericio456.Controllers;

import com.example.Ejericio456.Entity.Laptop;
import com.example.Ejericio456.Repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class laptopController {
    private LaptopRepository laptopRepository;

    public laptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
public List<Laptop> findAll() {
    return laptopRepository.findAll();
}
@PostMapping("/api/laptops")
public Laptop crear(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){

    System.out.println(headers.get("User-Agent"));
    return laptopRepository.save(laptop);
}
}
