package com.altima.sorel.exception;


/**
 * This exception created for  case where a requested card doesn't exist
 * @author sorelus Mkounga
 */
public class PositionInvalideException extends Exception {
    final String message ;
    public PositionInvalideException(int numero){
        message = "aucune carte n'existe a la position "+numero+" dans ce jeu";
    }
    @Override
    public String getMessage() {
        return message;
    }
}
