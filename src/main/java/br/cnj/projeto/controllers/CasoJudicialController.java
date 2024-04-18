package br.cnj.projeto.controllers;


import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import br.cnj.projeto.exceptions.CasoDuplicadoException;
import br.cnj.projeto.models.CasoJudicial;
import br.cnj.projeto.services.CasoJudicialService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {
    private final CasoJudicialService service;
    
    //@Autowired
    public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CasoJudicial>> getAllCasos() {
        List<CasoJudicial> casos = service.getAllCasos();

        return ResponseEntity.ok(casos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CasoJudicial> getCaseForId(@PathVariable Long id) {
        CasoJudicial caso = service.getCaseForId(id);

        return ResponseEntity.ok(caso);
    }

    @PostMapping
    public ResponseEntity<CasoJudicial> createCaso(@RequestBody CasoJudicial newCaso) throws CasoDuplicadoException {
        if(service.existe(newCaso)) {
           throw new CasoDuplicadoException("Caso Duplicado");
        }

        service.createCaso(newCaso);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(newCaso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasoJudicial> updateCaso(@PathVariable Long id, @RequestBody CasoJudicial updatedCaso) {
        service.updateCaso(id, updatedCaso);
        
        return ResponseEntity.ok(updatedCaso);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<String> adjustedCaso(@PathVariable Long id, @RequestBody Map<String, Object> updatesCaso) {
        if(service.updateCaso(id, updatesCaso))
            return ResponseEntity.ok("Sucesso ao atualizar o caso " + id);
        else
            return ResponseEntity.badRequest().body("Falha ao atualizar o caso " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCase(@PathVariable Long id) {
        service.deleteCaso(id);
        
        return ResponseEntity.noContent().build();
    }

}
