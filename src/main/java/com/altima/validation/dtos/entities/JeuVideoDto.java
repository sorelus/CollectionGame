package com.altima.validation.dtos.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * JeuVideoDto class use like a mapper version of jeuvideo entity
 *
 * @author sorelus Mkounga
 */

public class JeuVideoDto {

    private Integer id;


    /*
     Use to validate data from controller with @validate tag
     */
    @NotNull /* this property must not be null */
    @NotEmpty /* this property must not be empty */
    private String nom;


    private String editeur;


    @NotNull /* this property must not be null */
    /* handles data-binding (parsing) and display for spring form tld o*/
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateDeSortie;

    private ConsoleDto console;

    private String jaquette;


    public JeuVideoDto() {
        this.nom = "";
        dateDeSortie = new Date();
    }

    /**
     * JeuVideoDto constructor
     *
     * @param nom          jeuVideo name
     * @param editeur      jeuVideo editor
     * @param dateDeSortie create date
     * @param console      console platform for play
     */
    public JeuVideoDto(String nom, String editeur, Date dateDeSortie, ConsoleDto console) {
        this.nom = nom;
        this.editeur = editeur;

        this.dateDeSortie = dateDeSortie;
        this.console = console;
    }

    /*
     * begin define Getters and setters
     *
     */
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

    public ConsoleDto getConsole() {
        return console;
    }

    public void setConsole(ConsoleDto console) {
        this.console = console;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /*
     * END define getters and setters
     */

    /**
     * redefine toString function
     *
     * @return To return jeuVideoDto info
     */
    @Override
    public String toString() {
        return "JeuVideoDto{" +
                "nom='" + nom + '\'' +
                ", editeur='" + editeur + '\'' +
                ", dateDeSortie=" + dateDeSortie +
                ", console=" + console +
                '}';
    }

    public String getJaquette() {
        return jaquette;
    }

    public void setJaquette(String jaquette) {
        this.jaquette = jaquette;
    }

}
