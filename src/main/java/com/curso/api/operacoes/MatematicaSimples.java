package com.curso.api.operacoes;

import org.springframework.stereotype.Service;

@Service
public class MatematicaSimples {

    public Double soma(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtracao(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplicacao(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double divisao(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double media(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    public Double raizQuadrada(Double number) {
        return Math.sqrt(number);
    }

}
