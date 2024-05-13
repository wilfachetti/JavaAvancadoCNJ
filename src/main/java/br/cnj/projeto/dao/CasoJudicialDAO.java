package br.cnj.projeto.dao;

import java.util.List;

import br.cnj.projeto.models.CasoJudicial;

public interface CasoJudicialDAO {
    CasoJudicial findById(Long id);
    List<CasoJudicial> findAll();
    List<CasoJudicial> findAll(int page, int pagSize);
    List<CasoJudicial> findAll(int page, int pagSize, String sortBy, String sortOrder);
    void save(CasoJudicial casoJudicial);    
    void update(CasoJudicial updatedCaso);    
    void partialUpdate(Long id, CasoJudicial casoJudicial);
    void delete(Long id);
}
