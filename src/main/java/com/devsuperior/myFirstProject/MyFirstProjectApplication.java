package com.devsuperior.myFirstProject;

import com.devsuperior.myFirstProject.entities.Category;
import com.devsuperior.myFirstProject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyFirstProjectApplication implements CommandLineRunner
{
	public static void main(String[] args) {
		SpringApplication.run(MyFirstProjectApplication.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;

	// Faça isso ao começar a aplicação
	@Override
	public void run(String... args) throws Exception
	{
		Category cat1 = new Category(1L, "Electronics");
		Category cat2 = new Category(2L, "Books");
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
	}
}
