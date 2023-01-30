package com.example.springrestapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "candidat")
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    @NotNull(message = "Le champ nom ne peut pas etre null")
    @NotBlank(message =  "Le champ nom ne peut pas etre vide")
    private String nom;

    @Column(name = "prenom")
    @NotNull(message = "Le champ prenom ne peut pas etre null")
    @NotBlank(message =  "Le champ prenom ne peut pas etre vide")
    private String prenom;
    @NotNull(message = "Le champ date ne peut pas etre null")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @NotNull(message = "Le champ adresse ne peut pas etre null")
    @NotBlank(message =  "Le champ adresse ne peut pas etre vide")
    private String adresse;

    @NotNull(message = "Le champ ville ne peut pas etre null")
    @NotBlank(message =  "Le champ ville ne peut pas etre vide")
    private String ville;

    @NotNull(message = "Le champ code postal ne peut pas etre null")
    @NotBlank(message =  "Le champ code postal ne peut pas etre vide")
    private String codePostal;

    public Candidat() {
    }

    public Candidat(String nom, String prenom, Date dateNaissance, String adresse, String ville, String codePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                '}';
    }
}
