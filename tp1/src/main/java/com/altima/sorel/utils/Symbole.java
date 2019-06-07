package com.altima.sorel.utils;

/**
 * This is an enumeration that will use for  symbol of  cards. We have 4 symbols : TREFLE idem T, CARREAUX idem C, COEUR idem H and PIC idem P
 * @author sorelus Mkounga
 */
public enum Symbole {
    TREFLE("T"),CARREAUX("C"),COEUR("H"),PIC("P");

    private String value;
    Symbole (String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
