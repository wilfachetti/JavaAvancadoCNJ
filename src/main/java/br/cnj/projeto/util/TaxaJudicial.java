package br.cnj.projeto.util;

import org.springframework.stereotype.Component;

@Component
public class TaxaJudicial {
    public double adcionarTaxa(String estado) {
        double valor = 0;
        if(estado == "DF")
            valor = 10;
        else 
            valor = 20;

        return valor;
    }
}