package com.altima.sorel;

import com.altima.sorel.utils.Couleur;
import com.altima.sorel.utils.Symbole;
import com.altima.sorel.exception.NumeroCarteInvalideException;

/**
 * this class allows you to model the game card concept. it is composing :
 * - couleur ( emun Colour)
 * - symbole ( emun Symbole)
 * - numero ( int  from 1 to 10)
 * @author sorelus Mkounga
 */

public class Carte {
    private Couleur couleur;
    private Symbole symbole;
    private  int number;

    /**
     * Constructor of this class
     * @param couleur card color
     * @param symbole card symbol
     * @param number car number
     * @throws NumeroCarteInvalideException when number isn"t between 1 and 10
     *
     */
    public Carte(Couleur couleur, Symbole symbole, int number) throws NumeroCarteInvalideException{
        /*
         number is between 1 and 10
         */
        if(number<1 || number>10){
            throw new NumeroCarteInvalideException(number);
        }
        this.couleur = couleur;
        this.symbole = symbole;
        this.number = number;
    }

    /**
     *
     * @return Card color
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     *
     * @return card symbol
     */
    public Symbole getSymbole() {
        return symbole;
    }

    /**
     *
     * @return card number
     */
    public int getNumber() {
        return number;
    }


    /**
     * we redefine  toString function to display card info.
     * Format :
     * Symbole-Number
     * when Card is NOIR, Symbole is UpperCase and lowerCase when it's ROUGE
     * Exple : C-10 = couleur = NOIR and number = 10
     */
    @Override
    public String toString() {
        String ret = this.symbole +"-"+this.getNumber();
        if(this.couleur == Couleur.ROUGE)
            ret = ret.toLowerCase();

        return ret;
    }

}
