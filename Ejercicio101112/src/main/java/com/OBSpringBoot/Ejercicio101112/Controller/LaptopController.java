package com.OBSpringBoot.Ejercicio101112.Controller;

import com.OBSpringBoot.Ejercicio101112.Entity.Laptop;
import com.OBSpringBoot.Ejercicio101112.Repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    private final LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
       return  laptopRepository.findAll();
    }
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> finOneById(@PathVariable Long id) {
       Laptop lapFounded = laptopRepository.findById(id).get();
            return ResponseEntity.ok(lapFounded);


    }
@PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create( @RequestBody Laptop laptop) {
    Laptop lapcreated = laptopRepository.save(laptop);
    return ResponseEntity.ok(lapcreated);




}
@PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> update(@PathVariable Long id, @RequestBody Laptop laptop){
        Laptop modified = laptopRepository.save(laptop);
        return ResponseEntity.ok(modified);

}
@DeleteMapping("/api/laptops/{id}")
public void delete(@PathVariable Long id){
        laptopRepository.deleteById(id);

}

    }
