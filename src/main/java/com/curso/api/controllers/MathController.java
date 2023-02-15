package com.curso.api.controllers;

import com.curso.api.converters.ConverteNumero;
import com.curso.api.exceptions.UnsupportedMathOperationException;
import com.curso.api.operacoes.MatematicaSimples;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private final MatematicaSimples mateSimples;

    public MathController(MatematicaSimples mateSimples) {
        this.mateSimples = mateSimples;
    }


    @GetMapping("/soma/{numberOne}/{numberTwo}")
    public Double soma(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!ConverteNumero.isNumeric(numberOne) || !ConverteNumero.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        Double numbOneD = ConverteNumero.convertToDouble(numberOne);
        Double numbTwoD = ConverteNumero.convertToDouble(numberTwo);

        return mateSimples.soma(numbOneD, numbTwoD);
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!ConverteNumero.isNumeric(numberOne) || !ConverteNumero.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        Double numbOneD = ConverteNumero.convertToDouble(numberOne);
        Double numbTwoD = ConverteNumero.convertToDouble(numberTwo);

        return mateSimples.subtracao(numbOneD, numbTwoD);
    }

    @GetMapping("/multi/{numberOne}/{numberTwo}")
    public Double multi(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!ConverteNumero.isNumeric(numberOne) || !ConverteNumero.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        Double numbOneD = ConverteNumero.convertToDouble(numberOne);
        Double numbTwoD = ConverteNumero.convertToDouble(numberTwo);

        return mateSimples.multiplicacao(numbOneD, numbTwoD);
    }

    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!ConverteNumero.isNumeric(numberOne) || !ConverteNumero.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        Double numbOneD = ConverteNumero.convertToDouble(numberOne);
        Double numbTwoD = ConverteNumero.convertToDouble(numberTwo);

        if (numbOneD == 0 || numbTwoD == 0) {
            throw new UnsupportedMathOperationException("Não é possível dividir por 0!");
        }

        return mateSimples.divisao(numbOneD, numbTwoD);
    }

    @GetMapping("/media/{numberOne}/{numberTwo}")
    public Double media(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!ConverteNumero.isNumeric(numberOne) || !ConverteNumero.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        Double numbOneD = ConverteNumero.convertToDouble(numberOne);
        Double numbTwoD = ConverteNumero.convertToDouble(numberTwo);

        return mateSimples.media(numbOneD, numbTwoD);
    }

    @GetMapping("/raiz/{numberOne}")
    public Double raiz(@PathVariable String numberOne) throws Exception{

        if (!ConverteNumero.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        Double numbOneD = ConverteNumero.convertToDouble(numberOne);

        return mateSimples.raizQuadrada(numbOneD);
    }




}
