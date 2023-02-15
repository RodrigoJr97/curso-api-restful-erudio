package com.curso.api;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/soma/{numerOne}/{numberTwo}")
    public Double soma(@PathVariable String numerOne, @PathVariable String numberTwo) throws Exception{

        if (!isNumeric(numerOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }

        return convertToDouble(numerOne) + convertToDouble(numberTwo);
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
