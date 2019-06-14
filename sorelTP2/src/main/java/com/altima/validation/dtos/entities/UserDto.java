package com.altima.validation.dtos.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * UserDto class
 * @author sorelus Mkounga
 */

public class UserDto {


    private Integer id;

    private String nom;
    private String prenom;

    private String login;
    private String pass;
    /* handles data-binding (parsing) and display for spring form tld o*/
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateDeNaissance;


    List<JeuVideoDto> collection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {

        this.dateDeNaissance = dateDeNaissance;
    }

    public List<JeuVideoDto> getCollection() {
        return collection;
    }

    public void setCollection(List<JeuVideoDto> collection) {
        this.collection = collection;
    }
}
