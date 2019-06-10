package com.altima.validation.entities;


import java.util.Date;
/**
 * JeuVideo class
 * @author sorelus Mkounga
 */
public class JeuVideo {
    private String nom;
    private String editeur;
    private Date dateDeSortie;
    private Console console;


    /**
     * JeuVideo constructor
     * @param nom jeuVideo name
     * @param editeur jeuVideo editor
     * @param dateDeSortie create date
     * @param console console platform for play
     */
    public JeuVideo(String nom, String editeur, Date dateDeSortie, Console console) {
        this.nom = nom;
        this.editeur = editeur;
        this.dateDeSortie = dateDeSortie;
        this.console = console;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public Date getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(Date dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    /**
     *  redefine toString function
     * @return To return jeuVideo info
     */
    @Override
    public String toString() {
        return "JeuVideo{" +
                "nom='" + nom + '\'' +
                ", editeur='" + editeur + '\'' +
                ", dateDeSortie=" + dateDeSortie +
                ", console=" + console +
                '}';
    }
}
