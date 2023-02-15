package com.curso.api;

import com.curso.api.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/soma/{numberOne}/{numberTwo}")
    public Double soma(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @GetMapping("/multi/{numberOne}/{numberTwo}")
    public Double multi(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        Double numOne = convertToDouble(numberOne);
        Double numTwo = convertToDouble(numberTwo);

        if (numOne == 0 || numTwo == 0) {
            throw new UnsupportedMathOperationException("Não é possível dividir por 0!");
        }

        return numOne / numTwo;
    }

    @GetMapping("/media/{numberOne}/{numberTwo}")
    public Double media(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @GetMapping("/raiz/{numberOne}")
    public Double raiz(@PathVariable String numberOne) throws Exception{

        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Defina um valor númerico!");
        }

        Double numOne = convertToDouble(numberOne);
        return Math.sqrt(numOne);
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");

        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        }
        String number = strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
