package xyz.christophermedlin.cato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.entities.UsesIngredient;
import xyz.christophermedlin.cato.repositories.IngredientRepository;
import xyz.christophermedlin.cato.repositories.SmoothieRepository;
import xyz.christophermedlin.cato.repositories.UsesIngredientRepository;

@SpringBootApplication
@EnableJpaRepositories("xyz.christophermedlin.cato.repositories")
@EntityScan("xyz.christophermedlin.cato.entities")
public class CatoApplication {

	@Autowired
	IngredientRepository ingredientRepository;
	@Autowired
	SmoothieRepository smoothieRepository;

	@Autowired
	UsesIngredientRepository usesRepository;


	public static void main(String[] args) {
		SpringApplication.run(CatoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDB(ApplicationContext ctx) {
		return args -> {
			Smoothie s = new Smoothie("Banana");
			smoothieRepository.save(s);
			Ingredient i = new Ingredient("Banana");
			ingredientRepository.save(i);
			UsesIngredient u = new UsesIngredient(s, i);
			usesRepository.save(u);
			i = new Ingredient("Apple");
			ingredientRepository.save(i);
			u = new UsesIngredient(s, i);
			usesRepository.save(u);
		};
	}
}
