package com.altima.validation.utilis;

public class JeuException extends Exception {
    private final String message ;
    public JeuException(String msg){
        message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
