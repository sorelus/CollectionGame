package com.altima.sorel;

import com.altima.sorel.exception.NumeroCarteInvalideException;
import com.altima.sorel.exception.PositionInvalideException;
import com.altima.sorel.utils.Couleur;
import com.altima.sorel.utils.Symbole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;

/**
 * this class is the card game it allows to define all the functions allowing to manipulate the card game.
 * @author sorelus Mkounga
 */
public class JeuDeCartes {
    private List<Carte> jeu ;
    private static final  int MAX_ELEMENTS =10;

    public JeuDeCartes (){
        initGame();
    }

    /**
     * Init new Game of card
     */
    private void initGame() {
        chargerCartes(Symbole.TREFLE);
        chargerCartes(Symbole.CARREAUX);
        chargerCartes(Symbole.COEUR);
        chargerCartes(Symbole.PIC);
    }

    /**
     * function to create cards
     * @param symbole card symbol to create
     */
    private void chargerCartes(Symbole symbole){
        if(jeu==null)
            jeu = new ArrayList<>();

        List<Couleur> list = new ArrayList<>();
        list.add(Couleur.NOIR);
        list.add(Couleur.ROUGE);

        for (Couleur couleur:list)
            for(int i = 1; i<= MAX_ELEMENTS; i++){
                try {
                    jeu.add(new Carte(couleur, symbole, i));
                }catch (NumeroCarteInvalideException ex){
                    App.LOGGER.log(Level.SEVERE ,ex.getMessage());
                }
            }
    }

    /**
     * we redefine  toString function to display Game card info.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<8;i++){
            for (int j = 0; j< MAX_ELEMENTS; j++){
                stringBuilder.append(" [" +jeu.get(MAX_ELEMENTS *i + j).toString()+"] ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * it use to random mix Game Card
     */
    public void melangerJeuCarte(){
        Collections.shuffle(jeu);
    }


    public void trierJeuCarte(boolean desc){
        Comparator<Carte> comparator
                = (c1, c2) -> this.compare(c1,c2);
        if(desc)
           jeu.sort(comparator);
        else
            jeu.sort(comparator.reversed());
    }

    /**
     * Comparison based on color ( Rouge  then BLACK)
     * @param c1 carte 1
     * @param c2 carte 2
     * @return  return  result of the comparison
     * -1 if c1 is high than c2
     *  1 if c2 is high than c1
     *  0 if c1 and c2 are  equals
     */
    private int compare2cardsWithColor(Carte c1, Carte c2){
        int ret =0;
        if(c1.getCouleur()==Couleur.ROUGE && c1.getCouleur()!=c2.getCouleur()){
            ret = -1;
        }else if (c2.getCouleur()==Couleur.ROUGE && c2.getCouleur()!=c1.getCouleur()){
            ret=1;
        }
        return ret;
    }


    /**
     * Comparison based on Symbole ( TREFLE  then CARREAUX then COEUR then PIC )
     * @param c1 carte 1
     * @param c2 carte 2
     * @return  return  result of the comparison
     * -1 if c1 is high than c2
     *  1 if c2 is high than c1
     *  0 if c1 and c2 are  equals
     */
    private int compareWithSymbol(Carte c1, Carte c2){
        int ret =0;
        if(c1.getSymbole()==Symbole.TREFLE && c2.getSymbole()!=Symbole.TREFLE)
            ret = -1;
        else if(c2.getSymbole()==Symbole.TREFLE && c1.getSymbole()!=Symbole.TREFLE)
            ret = 1;
        else if(c1.getSymbole()==Symbole.CARREAUX && c2.getSymbole()!=Symbole.CARREAUX)
            ret = -1;
        else if(c2.getSymbole()==Symbole.CARREAUX && c1.getSymbole()!=Symbole.CARREAUX)
            ret = 1;
        else if(c1.getSymbole()==Symbole.COEUR && c2.getSymbole()!=Symbole.COEUR)
            ret = -1;
        else if(c2.getSymbole()==Symbole.COEUR && c1.getSymbole()!=Symbole.COEUR)
            ret = 1;
        else if(c1.getSymbole()==Symbole.PIC && c2.getSymbole()!=Symbole.PIC)
            ret = -1;
        else if(c2.getSymbole()==Symbole.PIC && c1.getSymbole()!=Symbole.PIC)
            ret = 1;
        return ret;
    }

    /**
     * Comparison based on Number ( from 1 to 10)
     * @param c1 carte 1
     * @param c2 carte 2
     * @return  return  result of the comparison
     * -1 if c1 is high than c2
     *  1 if c2 is high than c1
     *  0 if c1 and c2 are  equals
     */
    private int compare2cardsWithNumber(Carte c1, Carte c2){
        return c1.getNumber()-c2.getNumber();
    }


    /**
     * Comparison based on color then symbole them number
     * @param c1 carte 1
     * @param c2 carte 2
     * @return  return  result of the comparison
     * -1 if c1 is high than c2
     *  1 if c2 is high than c1
     *  0 if c1 and c2 are  equals
     */
    private   int compare(Carte c1, Carte c2){
        int ret =0;
        ret = compare2cardsWithColor(c1,c2);
        if(ret==0){
            ret = compareWithSymbol(c1,c2);
        }
        if (ret ==0){
            ret = compare2cardsWithNumber(c1,c2);
        }

        return ret;
    }

    /**
     *
     * To select one random carte ,  we will  mix game card and get cart from list (position list)
     * @param position
     * @return select card
     * @throws PositionInvalideException when card position is invalid
     */
    public Carte piochezUneCarte(int position) throws PositionInvalideException {
        if( position> jeu.size() || position<=0){
            throw new PositionInvalideException(position);
        }
        melangerJeuCarte();
        return jeu.get(position-1);
    }

}
