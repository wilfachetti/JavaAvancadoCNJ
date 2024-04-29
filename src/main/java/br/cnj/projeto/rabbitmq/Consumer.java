package br.cnj.projeto.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.cnj.projeto.config.QueueConfig;
import br.cnj.projeto.models.CasoJudicial;

@Component
public class Consumer {

    @RabbitListener(queues = { QueueConfig.QUEUE_NAME })
    public void receive(@Payload String fileBody) {
        System.out.println("CASO JUDICIAL RECEBIDO: " + fileBody);
    }

    @RabbitListener(queues = { QueueConfig.QUEUE_NAME })
    public void receive(@Payload CasoJudicial fileBody) {
        System.out.println("Caso judicial recebido: " + fileBody.toString());
    }
}
