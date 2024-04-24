package br.cnj.projeto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Component
@Entity
@Table(name = "casosjudiciais")
public class CasoJudicial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;

    public CasoJudicial() {
    }

    public CasoJudicial(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // public CasoJudicial(CustoJudicial custo, TaxaJudicial taxa) {
    //     this.custoJudicial = custo;
    //     this.taxaJudicial = taxa;
    // }

    // public double finalizarCusto(double custo, String estado, int anoJulgamento) {
    //     custo += custoJudicial.adicionarCusto(anoJulgamento);
    //     custo += taxaJudicial.adcionarTaxa(estado);
        
    //     return custo;
    // }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}