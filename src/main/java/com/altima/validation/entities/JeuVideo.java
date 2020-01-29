package com.altima.validation.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * JeuVideo class
 *
 * @author sorelus Mkounga
 */
@Entity // This tells Hibernate to make a table out of this class
public class JeuVideo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String nom;


    private String editeur;

    private Date dateDeSortie;

    @ManyToOne(fetch = FetchType.EAGER)
    private Console console;

    private String jaquette;

    // constructor use by JPA/Hibernate to instance new console
    public JeuVideo() {
    }

    /**
     * JeuVideo constructor
     *
     * @param nom          jeuVideo name
     * @param editeur      jeuVideo editor
     * @param dateDeSortie create date
     * @param console      console platform for play
     */
    public JeuVideo(String nom, String editeur, Date dateDeSortie, Console console) {
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

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
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

    public String getJaquette() {
        return jaquette;
    }

    public void setJaquette(String jaquette) {
        this.jaquette = jaquette;
    }
}
