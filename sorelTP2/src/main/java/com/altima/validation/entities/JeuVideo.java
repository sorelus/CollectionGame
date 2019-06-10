package com.altima.validation.entities;

import java.util.Date;

public class JeuVideo {
    private String nom, editeur;
    private Date dateDeSortie;
    private Console console;


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
}
