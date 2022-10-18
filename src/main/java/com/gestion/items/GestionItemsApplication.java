package com.gestion.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;



// permitir que hayan repositorios JPA
@EnableJpaRepositories(basePackages = {
		"com.gestion.items",
})
// Paquetes donde están todos los componentes inyectables Service, Component Controllers
@ComponentScan({
		"com.gestion.items",
})
// Paquetes donde están las entidades JPA
@EntityScan({
		"com.gestion.items"
})

@Component
@SpringBootApplication
@EnableScheduling
public class GestionItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionItemsApplication.class, args);
	}

}
