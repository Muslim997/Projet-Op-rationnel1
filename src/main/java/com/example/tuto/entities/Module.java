package com.example.tuto.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int nombreSemaines = 10;

    @OneToMany(mappedBy = "module")
    private List<Affectation> affectations;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreSemaines() {
        return nombreSemaines;
    }

    public void setNombreSemaines(int nombreSemaines) {
        this.nombreSemaines = nombreSemaines;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }
}
