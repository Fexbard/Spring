package com.example.Ejericio456;

import com.example.Ejericio456.Entity.Laptop;
import com.example.Ejericio456.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejericio456Application {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(Ejericio456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		Laptop laptop1 = new Laptop(null,"Dell","G3",600,true);
		Laptop laptop2 = new Laptop(null,"Asus","Zen book 13",700,true);
		Laptop laptop3 = new Laptop(null,"Dell","Alienware",2500,false);
		Laptop laptop4 = new Laptop(null,"Acer","Aspire",400,true);

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);
		repository.save(laptop4);
	}

}
