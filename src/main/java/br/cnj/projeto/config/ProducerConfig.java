package br.cnj.projeto.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig { 
    
    @Value(QueueConfig.NAME_FILA)
    private String message;
    
    @Bean public Queue producerQueue() {
        return new Queue(message, true); 
    }
}
