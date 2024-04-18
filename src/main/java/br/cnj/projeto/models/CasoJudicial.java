package br.cnj.projeto.models;

import org.springframework.stereotype.Component;

import br.cnj.projeto.util.CustoJudicial;
import br.cnj.projeto.util.TaxaJudicial;

@Component
public class CasoJudicial {
    private Long id;
    private String descricao;
    private CustoJudicial custoJudicial;
    private TaxaJudicial taxaJudicial;

    public CasoJudicial() {
        super();
    }

    public CasoJudicial(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public CasoJudicial(CustoJudicial custo, TaxaJudicial taxa) {
        this.custoJudicial = custo;
        this.taxaJudicial = taxa;
    }

    public double finalizarCusto(double custo, String estado, int anoJulgamento) {
        custo += custoJudicial.adicionarCusto(anoJulgamento);
        custo += taxaJudicial.adcionarTaxa(estado);
        
        return custo;
    }    

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}