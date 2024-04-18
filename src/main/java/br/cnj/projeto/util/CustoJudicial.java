package br.cnj.projeto.util;

import org.springframework.stereotype.Component;

@Component
public class CustoJudicial {
    public double adicionarCusto(int ano) {
        double valor = 0;

        if(ano >= 2024) {
            valor += 20;
        } else {
            valor += 10;
        }

        return valor;
    }
}

    