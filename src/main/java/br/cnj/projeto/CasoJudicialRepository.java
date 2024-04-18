package br.cnj.projeto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.cnj.projeto.models.CasoJudicial;

@Repository
public class CasoJudicialRepository {
    private List<CasoJudicial> list;

    public CasoJudicialRepository() {
        this.list = new ArrayList<CasoJudicial>(Arrays.asList(new CasoJudicial[] {
            new CasoJudicial(1l, "Caso 01"),
            new CasoJudicial(2l, "Caso 02"),
            new CasoJudicial(3l, "Caso 03"),
            new CasoJudicial(4l, "Caso 04"),
        }));
    }

    public List<CasoJudicial> findAll() {
        return list;
    }

    public void addCase(CasoJudicial newCase) {
        list.add(newCase);
    }

    public void removeCase(CasoJudicial caseLaw) {
        list.remove(caseLaw);
    }
    
}
