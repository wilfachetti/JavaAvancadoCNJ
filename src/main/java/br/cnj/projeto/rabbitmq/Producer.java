package br.cnj.projeto.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnj.projeto.models.CasoJudicial;

@Component
public class Producer {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(CasoJudicial order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }
}
