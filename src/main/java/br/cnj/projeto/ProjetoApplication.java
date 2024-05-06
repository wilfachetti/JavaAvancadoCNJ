package br.cnj.projeto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableRabbit
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Casos Judiciais OpenApi", version = "0.0.1", description = "API do projeto Casos Judiciais"))
public class ProjetoApplication {	
	private static final Logger logger = LogManager.getLogger(ProjetoApplication.class);
	
	public static void main(String[] args) {
		if (logger.isDebugEnabled()) 
            logger.debug("Hello from Log4j 2");

		logger.info("Starting the demo. ");

		
		
		SpringApplication.run(ProjetoApplication.class, args);



		logger.warn("Exception must occur now.");		
		try {
			throw new Exception("Throwing exception for demonstration");
		}
		catch(Exception e){
			logger.error("Exception occured.", e.getMessage(), e);
		}

		logger.info("Ending the demo. ");
	}
}
