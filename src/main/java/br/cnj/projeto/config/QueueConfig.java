package br.cnj.projeto.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;

@Configuration
public class QueueConfig {

    public static final String QUEUE_NAME = "Casos";
    public static final String EXCHANGE_NAME = "ExchangeCasos";
    public static final String ROUTING_KEY = "CriarCaso";
    
    @Bean
    DirectExchange userExchange() { 
        return new DirectExchange(EXCHANGE_NAME);
    }
    
    @Bean
    Queue queue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }
    
    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(userExchange()) .with(ROUTING_KEY);
    }
}
