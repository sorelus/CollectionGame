package com.altima.validation.dtos.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserDto class
 *
 * @author sorelus Mkounga
 */

public class UserDto {


    Set<JeuVideoDto> collection;
    private Integer id;
    private Set<String> roles;
    /*
     Use to validate data from controller with @validate tag
     */
    @NotNull /* this property must not be null */
    @NotEmpty /* this property must not be empty */
    private String nom;
    private String prenom;
    @NotNull /* this property must not be null */
    @NotEmpty /* this property must not be empty */
    private String login;
    /* handles data-binding (parsing) and display for spring */
    @NotNull /* this property must not be null */
    @NotEmpty /* this property must not be empty */
    private String pass;
    @NotNull /* this property must not be null */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateDeNaissance;

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

    public Set<JeuVideoDto> getCollection() {
        return collection;
    }

    public void setCollection(Set<JeuVideoDto> collection) {
        this.collection = collection;
    }

    /* Use to qdd jeuVideo from collection*/
    public void addToCollection(JeuVideoDto jeuVideoDto) {
        if (collection == null)
            collection = new HashSet<>();
        collection.add(jeuVideoDto);

    }

    /* Use to delete jeuVideo from collection*/
    public void deleteFromColection(int jeuId) {
        if (collection != null) {
            collection.removeIf(x -> x.getId() == jeuId
            );
        }
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", collection=" + collection +
                '}';
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void addRole(String role){
       if(roles==null)
           roles = new HashSet<>();
        roles.add(role);
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
