package com.OBSpringBoot.Ejercicio101112;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.OBSpringBoot.Ejercicio101112.Entity.Laptop;
import com.OBSpringBoot.Ejercicio101112.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class Ejercicio101112Application {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio101112Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

		Laptop laptop1 = new Laptop(null,passwordEncoder.encode("clave1"),"Toshiba","Satellite",345.50,false);
		Laptop laptop2 = new Laptop(null,passwordEncoder.encode("clave2"),"Dell","G-3",650.00,true);
		Laptop laptop3 = new Laptop(null,passwordEncoder.encode("clave3"),"Acer","Aspire",305.50,true);
		Laptop laptop4 = new Laptop(null,passwordEncoder.encode("clave4"),"Lenovo","Zen",790.00,true);
		Laptop laptop5 = new Laptop(null,passwordEncoder.encode("clave5"),"Dell","Allienware",1345.50,true);
		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);
		laptopRepository.save(laptop3);
		laptopRepository.save(laptop4);
		laptopRepository.save(laptop5);




	}

}