package br.cnj.projeto.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cnj.projeto.CasoJudicialRepository;
import br.cnj.projeto.models.CasoJudicial;

@Service
public class CasoJudicialService {
    private final CasoJudicialRepository repository;

    //@Autowired
    public CasoJudicialService(CasoJudicialRepository repository) {
        this.repository = repository;
    }

    public boolean existe(CasoJudicial caso) {
        for(CasoJudicial casoJudicial: repository.findAll()) 
            if(casoJudicial.getId() == caso.getId())
                return true;
        return false;
    }

    public List<CasoJudicial> getAllCasos() {
        //return repository.findAll();
        return repository.findAll();
    }

    public CasoJudicial getCaseForId(Long id) {
        for(CasoJudicial casoJudicial: repository.findAll()) 
            if(casoJudicial.getId() == id)
                return casoJudicial;
        
        return null;
    }

    public CasoJudicial createCaso(CasoJudicial newCaso) {
        repository.addCase(newCaso);

        return newCaso;
    }

    public CasoJudicial updateCaso(Long id, CasoJudicial updatedCaso) {
        repository.removeCase(getCaseForId(id));
        repository.addCase(updatedCaso);

        return updatedCaso;
    }

    public boolean updateCaso(Long id, Map<String, Object> updatesCaso) {  
        CasoJudicial caso = getCaseForId(id);
        
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

    public void deleteCaso(Long id) {
        repository.removeCase(getCaseForId(id));
    }

}
