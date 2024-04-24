package br.cnj.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.projeto.rabbitmq.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/fila")
public class QueueController {

    @Autowired
    private Producer producer;
    
    // @GetMapping 
    // public String send(){
    //     producer.send("ENVIANDO ISSO!");
    //     return "Enviado.";
    // } 

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        producer.send(message);
        return ResponseEntity.ok("Mensagem: " + message + " enviada para a fila com sucesso.");
    }
    
}
