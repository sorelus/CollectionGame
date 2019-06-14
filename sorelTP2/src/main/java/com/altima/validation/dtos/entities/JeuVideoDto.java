package com.altima.validation.dtos.entities;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * JeuVideoDto class use like a mapper version of jeuvideo entity
 * @author sorelus Mkounga
 */

public class JeuVideoDto {

    private Integer id;

    private String nom;


    private String editeur;

    /* handles data-binding (parsing) and display for spring form tld o*/
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateDeSortie;

    private ConsoleDto console;


    public JeuVideoDto() {
    }

    /**
     * JeuVideoDto constructor
     * @param nom jeuVideo name
     * @param editeur jeuVideo editor
     * @param dateDeSortie create date
     * @param console console platform for play
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
     *  redefine toString function
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
}
