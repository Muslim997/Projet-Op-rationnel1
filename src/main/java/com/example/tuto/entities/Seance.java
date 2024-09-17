package com.example.tuto.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "affectation_id", nullable = false)
    private Affectation affectation;

    @Column(nullable = false)
    private LocalDate dateSeance;

    @Column(nullable = false)
    private boolean effectuee;

    @Column(nullable = false)
    private int heuresEffectuees = 0;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }

    public LocalDate getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(LocalDate dateSeance) {
        this.dateSeance = dateSeance;
    }

    public boolean isEffectuee() {
        return effectuee;
    }

    public void setEffectuee(boolean effectuee) {
        this.effectuee = effectuee;
    }

    public int getHeuresEffectuees() {
        return heuresEffectuees;
    }

    public void setHeuresEffectuees(int heuresEffectuees) {
        this.heuresEffectuees = heuresEffectuees;
    }
}
