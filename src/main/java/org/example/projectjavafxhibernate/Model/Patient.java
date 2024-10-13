package org.example.projectjavafxhibernate.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String tel;
    private String email;
    private String sexe;
    private String gsanguin;
    private String situation;

    public Patient() {
    }
    public Patient(String nom, String prenom, Date dateNaissance, String adresse, String tel, String email, String sexe, String gsanguin, String situation) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.sexe = sexe;
        this.gsanguin = gsanguin;
        this.situation = situation;
    }


}
