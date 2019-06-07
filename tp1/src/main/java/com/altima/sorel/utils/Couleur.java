package com.altima.sorel.utils;


/**
 * This is an enumeration that will use for  color of  cards. We have 2 colors : NOIR and ROUGE
 * @author sorelus Mkounga
 */
public enum Couleur {
    NOIR ("Noir"),
    ROUGE ("Rouge");

    private String value;

     Couleur(String value){
       this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
