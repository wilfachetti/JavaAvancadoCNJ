package br.cnj.projeto;

import java.util.Arrays;
import java.util.List;

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
public class ProjetoApplication { // implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(ProjetoApplication.class);
	
	public static void main(String[] args) {
		if (logger.isDebugEnabled()) {
            logger.debug("Hello from Log4j 2 - num : {}");
        }

		SpringApplication.run(ProjetoApplication.class, args);


		logger.info("Starting the demo. ");

    //Lets throw exception but before that let's warn.
    logger.warn("Exception must occur now.");
    try {
        throw new Exception("Throwing exception for demonstration");
    }
    catch(Exception e){
        logger.error("Exception occured.", e.getMessage(), e);
    }

    logger.info("Ending the demo. ");

	}

	/* 
	@Autowired
	private CasoJudicial caso;

	@Override
	public void run(String... args) throws Exception {
		System.out.printf("Valor final do processo: R$ %s", caso.finalizarCusto(100, "RO", 2017));
	}
	*/
}
