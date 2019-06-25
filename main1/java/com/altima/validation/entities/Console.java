package com.altima.validation.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Console class
 *
 * @author sorelus Mkounga
 */

@Entity // This tells Hibernate to make a table out of this class
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String nom;

    private String fabricant;

    private Date dateDeSortie;

    private int bits;

    // constructor use by JPA/Hibernate to instance new console
    public Console() {
    }

    /**
     * Console contructeur
     *
     * @param nom          console name
     * @param fabricant    console constructor
     * @param dateDeSortie create date
     * @param bits         console bit
     */
    public Console(String nom, String fabricant, Date dateDeSortie, int bits) {
        this.nom = nom;
        this.fabricant = fabricant;
        this.dateDeSortie = dateDeSortie;
        this.bits = bits;
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


    public Date getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(Date dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
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
     * @return To return console info
     */
    @Override
    public String toString() {
        return "Console{" +
                "nom='" + nom + '\'' +
                ", fabricant='" + fabricant + '\'' +
                ", dateDeSortie=" + dateDeSortie +
                ", bits=" + bits +
                '}';
    }
}
