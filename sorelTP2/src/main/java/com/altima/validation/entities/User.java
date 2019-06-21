package com.altima.validation.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * User class
 *
 * @author sorelus Mkounga
 */
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @ManyToMany(fetch = FetchType.EAGER)
    Set<JeuVideo> collection;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String login;
    private String pass;
    private Date dateDeNaissance;

    @ElementCollection(targetClass=String.class) // use to help hibernate to determinate Type of set
    private Set<String> roles;

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

    public Set<JeuVideo> getCollection() {
        return collection;
    }

    public void setCollection(Set<JeuVideo> collection) {
        this.collection = collection;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
