package com.OBSpringBoot.Ejercicio101112.Repository;

import com.OBSpringBoot.Ejercicio101112.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
