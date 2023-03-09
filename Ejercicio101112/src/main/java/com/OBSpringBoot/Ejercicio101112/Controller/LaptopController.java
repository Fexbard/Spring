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
       Laptop laptopFounded = laptopRepository.findById(id).get();
            return ResponseEntity.ok(laptopFounded);

    }
@PostMapping("/api/add/laptops")
    public ResponseEntity<Laptop> create( @RequestBody Laptop laptop) {
    Laptop laptopCreated = laptopRepository.save(laptop);
    return ResponseEntity.ok().build(); // ver más opciones de retorno

}
@PutMapping("/api/modify/laptops/{id}")
    public ResponseEntity<Laptop> update(@PathVariable Long id, @RequestBody Laptop laptop){
        Laptop laptopModified = laptopRepository.save(laptop);
        return ResponseEntity.ok(laptopModified);

}
@DeleteMapping("/api/delete/{id}")
public String delete(@PathVariable Long id){
        laptopRepository.deleteById(id);
return  "El ítem"+ laptopRepository.getReferenceById(id)+"ha sido borrado";
}

    }
