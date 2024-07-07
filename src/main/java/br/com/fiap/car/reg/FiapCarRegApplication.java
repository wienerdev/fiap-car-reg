package br.com.fiap.car.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FiapCarRegApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiapCarRegApplication.class, args);
	}

}
