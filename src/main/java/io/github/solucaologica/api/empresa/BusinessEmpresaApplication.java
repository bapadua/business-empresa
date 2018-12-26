package io.github.solucaologica.api.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"io.github.solucaologica.api.core.**"})
@ComponentScan(basePackages = {"io.github.solucaologica.api.**"})
@EnableJpaRepositories(basePackages = {"io.github.solucaologica.api.**"})
public class BusinessEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessEmpresaApplication.class, args);
	}

}

