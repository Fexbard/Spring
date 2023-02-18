package com.example.proyectoJPASpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class ProyectoJpaSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context	= SpringApplication.run(ProyectoJpaSpringApplication.class, args);
		CocheRepository repository = context.getBean(CocheRepository.class);
		System.out.println("La cantidad de es "+repository.count());
		Coche coche = new Coche(null,"Toyota","Yaris",2010);
		repository.save(coche);
		System.out.println("El coche es: "+ repository.findAll());

	}

}
