package br.cnj.projeto;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableRabbit
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Casos Judiciais OpenApi", version = "0.0.1", description = "API do projeto Casos Judiciais"))
public class ProjetoApplication {	
	
	public static void main(String[] args) {
	
		SpringApplication.run(ProjetoApplication.class, args);

	}
}
