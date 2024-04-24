package br.cnj.projeto.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.cnj.projeto.models.CasoJudicial;
import br.cnj.projeto.repository.CasosJudiciaisRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CasoJudicialService {
    private final CasosJudiciaisRepository repository;

    //@Autowired
    public CasoJudicialService(CasosJudiciaisRepository repository) {
        this.repository = repository;
    }

    public boolean dataValidator(CasoJudicial caso) {
        if(!caso.getDescricao().isEmpty())
            return true;
        return false;
    }

    public List<CasoJudicial> getAll() {
        return repository.findAll();
    }

    public CasoJudicial findById(Long id) {
        Optional<CasoJudicial> caso = repository.findById(id);
        return caso.get();
    }

    public CasoJudicial createCase(CasoJudicial newCase) {
        repository.save(newCase);

        return newCase;
    }

    public CasoJudicial updateCase(long id, CasoJudicial updatedCaso) {     
        Optional<CasoJudicial> caso = repository.findById(id);
        
        if(caso.isPresent()) {
            CasoJudicial casoAtualizado = caso.get();
            casoAtualizado.setDescricao(updatedCaso.getDescricao());
            repository.save(casoAtualizado);
        }

        return caso.get();
    }
    
    public boolean updateCaso(Long id, Map<String, Object> updatesCaso) {  
        Optional<CasoJudicial> caso = repository.findById(id);//getCaseForId(id);
        
        for(Map.Entry<String, Object> entry: updatesCaso.entrySet()){
            String chave = entry.getKey();
            Object valor = entry.getValue();

            try {
                caso.getClass().getDeclaredField(chave).setAccessible(true);
                caso.getClass().getDeclaredField(chave).set(caso, valor);
            } catch(NoSuchFieldException | IllegalAccessException e) {
                return false;
            }
        }
        return true;
    }

    public void deleteCase(Long id) {
        repository.deleteById(id);
    }

}
