package br.cnj.projeto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.cnj.projeto.dao.CasoJudicialDAO;
import br.cnj.projeto.models.CasoJudicial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CasoJudicialDaoImpl implements CasoJudicialDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<CasoJudicial> findAll() {
        return entityManager.createQuery("SELECT c FROM CasoJudicial c", CasoJudicial.class).getResultList();
    }
    
    @Override
    public CasoJudicial findById(Long id) {
        return entityManager.find(CasoJudicial.class, id);
    }

    @Override
    public List<CasoJudicial> findAll(int page, int pagSize) {
        int offset = (page - 1) * pagSize;
        return entityManager.createQuery("SELECT c FROM CasoJudicial c", CasoJudicial.class)
                .setFirstResult(offset)
                .setMaxResults(pagSize)
                .getResultList();
    }

    @Override
    public List<CasoJudicial> findAll(int page, int pagSize, String sortBy, String sortOrder) {
        int offset = (page - 1) * pagSize;
        String queryString = "SELECT c FROM CasoJudicial c ORDER BY c." + sortBy + "  " + sortOrder;
        return entityManager.createQuery(queryString, CasoJudicial.class)
                .setFirstResult(offset)
                .setMaxResults(pagSize)
                .getResultList();
    }

    @Override
    public void save(CasoJudicial casoJudicial) {
        entityManager.persist(casoJudicial);
    }

    @Override
    public void update(CasoJudicial casoJudicial) {
        entityManager.merge(casoJudicial);
    }

    @Override
    public void partialUpdate(Long id, CasoJudicial casoJudicial) {
        CasoJudicial existingCasoJudicial = findById(id);
        
        if(existingCasoJudicial != null){
            if(casoJudicial.getDescricao() != null) {
                existingCasoJudicial.setDecisao(casoJudicial.getDecisao());
                existingCasoJudicial.setDescricao(casoJudicial.getDescricao());
            }

            entityManager.merge(existingCasoJudicial);
        }
    }

    @Override
    public void delete(Long id) {
        CasoJudicial casoJudicial = findById(id);
        if(casoJudicial != null)
            entityManager.remove(casoJudicial);
    }

}
