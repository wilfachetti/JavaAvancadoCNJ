package br.cnj.projeto;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ProjetoApplication { // implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
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
