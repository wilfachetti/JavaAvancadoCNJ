package br.cnj.projeto.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasoJudicialDTO implements Serializable {
    @JsonProperty
    private char decisao;
    @JsonProperty
    private String descricao;

    @Override
    public String toString() {
        return "CasoJudicial{" +
                "decisao='" + decisao + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
