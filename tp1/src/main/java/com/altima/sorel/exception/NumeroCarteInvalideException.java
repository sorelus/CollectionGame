package com.altima.sorel.exception;


/**
 * this exception was created for the case of creating a card with an invalid number
 * @author sorelus Mkounga
 */
public class NumeroCarteInvalideException extends Exception {
    final String message ;
    public NumeroCarteInvalideException(int numero){
        message = "une carte ne peut pas contenir le numero "+numero +".\n Les numeros de carte doivent etre comprisent entre 1 et 10";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
