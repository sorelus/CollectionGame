package com.altima.validation.dtos.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ConsoleDto class use like a mapper version of Console entity
 *
 * @author sorelus Mkounga
 */

public class ConsoleDto {

    private Integer id;


    /*
     Use to validate data from controller with @validate tag
     */
    @NotNull /* this property must not be null */
    @NotEmpty /* this property must not be empty */
    private String nom;


    private String fabricant;

    @NotNull /* this property must not be null */
    /* handles data-binding (parsing) and display for spring form tld o*/
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateDeSortie;

    private int bits;

    public ConsoleDto() {
    }

    /**
     * ConsoleDto contructeur
     *
     * @param nom          console name
     * @param fabricant    console constructor
     * @param dateDeSortie create date
     * @param bits         console bit
     */
    public ConsoleDto(String nom, String fabricant, Date dateDeSortie, int bits) {
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
     * @return To return consoleDto info
     */
    @Override
    public String toString() {
        return "ConsoleDto{" +
                "nom='" + nom + '\'' +
                ", fabricant='" + fabricant + '\'' +
                ", dateDeSortie=" + dateDeSortie +
                ", bits=" + bits +
                '}';
    }
}
