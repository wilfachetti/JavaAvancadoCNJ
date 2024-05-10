package br.cnj.projeto.rabbitmq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnj.projeto.dto.CasoJudicialDTO;

@Component
public class Producer {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;    
    @Autowired
    private Queue queue;
    
    private static Logger logger = LogManager.getLogger(Producer.class.toString());

    public void send(CasoJudicialDTO casoJudicial) {
        rabbitTemplate.convertAndSend(this.queue.getName(), casoJudicial);
        
        logger.info("Sending Message to the Queue: " + casoJudicial.toString());
    }
}
