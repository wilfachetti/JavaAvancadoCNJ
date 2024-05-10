package br.cnj.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.projeto.dto.CasoJudicialDTO;
import br.cnj.projeto.rabbitmq.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/queue")
public class QueueController {

    @Autowired
    private Producer producer;
    
    @PostMapping(value = "/sender")
    public ResponseEntity<String> sendMessage(@RequestBody CasoJudicialDTO casoJudicialDTO) {
    //public String producer(@RequestBody CasoJudicialDTO casoJudicialDTO) {
        producer.send(casoJudicialDTO);
        return ResponseEntity.ok("Mensagem enviada para a fila com sucesso.");
        //return "Mensagem!";
    }
    
    // Modelo envio de texto simples
    // @PostMapping
    // public ResponseEntity<String> sendMessage(@RequestBody String message) {
    //     producer.send(message);
    //     return ResponseEntity.ok("Mensagem: " + message + " enviada para a fila com sucesso.");
    // }
}
