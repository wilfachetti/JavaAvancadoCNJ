package br.cnj.projeto.rabbitmq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.cnj.projeto.config.RabbitMQConfig;
import br.cnj.projeto.dto.CasoJudicialDTO;

@Component
public class Consumer {
    private static Logger logger = LogManager.getLogger(Consumer.class.toString());

    // Modelo para envio de texto puro
    // @RabbitListener(queues = { QueueConfig.QUEUE_NAME })
    // public void receive(@Payload String text) {
    //    logger.info("Caso Judicial listener invoked - Consuming Message with CasoJudicialDTO Description: " + text);
    // }

    @RabbitListener(queues = { RabbitMQConfig.QUEUE_NAME })
    public void receive(@Payload CasoJudicialDTO casoJudicialDTO) {
        logger.info("Caso Judicial listener invoked - Consuming Message with CasoJudicialDTO Description: " + casoJudicialDTO.getDescricao());
    }
}
