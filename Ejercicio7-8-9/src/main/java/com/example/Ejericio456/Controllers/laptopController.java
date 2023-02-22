package com.example.Ejericio456.Controllers;

import com.example.Ejericio456.Entity.Laptop;
import com.example.Ejericio456.Repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class laptopController {
    private final Logger log = LoggerFactory.getLogger(laptopController.class);
    private LaptopRepository laptopRepository;

    public laptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
public List<Laptop> findAll() {
    return laptopRepository.findAll();
}

@GetMapping("/api/laptops/{id}")
public ResponseEntity <Laptop> findOneById(@PathVariable Long id) {
Optional<Laptop> laptopOptional =laptopRepository.findById(id);

if (laptopOptional.isPresent()){
    Laptop result = laptopOptional.get();
    return ResponseEntity.ok(result);
}
    return ResponseEntity.notFound().build();
    }

@PostMapping("/api/laptops")
public ResponseEntity <Laptop> crear(@RequestBody Laptop laptop){
if (laptop.getId() != null){
    log.warn("Tratando de crear un libro con ID incluído");
     return ResponseEntity.badRequest().build();
}
 Laptop result = laptopRepository.save(laptop);
    return ResponseEntity.ok(result);

}
@PutMapping("/api/laptops")
public ResponseEntity <Laptop> update(@RequestBody Laptop laptop){
    if (laptop.getId() == null){
        log.warn("Tratando de actualizar un libro inexistente");
        return ResponseEntity.notFound().build();
    }
    Laptop result = laptopRepository.save(laptop);
    return ResponseEntity.ok(result);
}

@DeleteMapping("/api/laptops/{id}")
public  ResponseEntity <Laptop> delete(@PathVariable Long id){
    if (!laptopRepository.existsById(id)){
        log.warn("Tratando de borrar un libro inexistente");
        return ResponseEntity.notFound().build();
    }
    laptopRepository.deleteById(id);
    return ResponseEntity.noContent().build();
}
@DeleteMapping("/api/laptops")
public ResponseEntity <Laptop> deleteAll(){
    log.info("Borrando todo el respositorio");
    laptopRepository.deleteAll();
    return ResponseEntity.noContent().build();

}
}







