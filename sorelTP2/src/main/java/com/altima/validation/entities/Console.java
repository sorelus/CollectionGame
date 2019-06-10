package com.altima.validation.entities;


import org.springframework.context.annotation.Bean;

import java.util.Date;


public class Console {
    private String nom,fabricant;
    private Date dateDeSortie;
    private int nombreDeBits;


    public Console(String nom, String fabricant, Date dateDeSortie, int nombreDeBits) {
        this.nom = nom;
        this.fabricant = fabricant;
        this.dateDeSortie = dateDeSortie;
        this.nombreDeBits = nombreDeBits;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public Date getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(Date dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public int getNombreDeBits() {
        return nombreDeBits;
    }

    public void setNombreDeBits(int nombreDeBits) {
        this.nombreDeBits = nombreDeBits;
    }
}
