package com.example.tuto.entities;

import jakarta.persistence.*;
import java.util.List;

import com.example.tuto.entities.Groupe;
import com.example.tuto.entities.Module;
import com.example.tuto.entities.Seance;
import com.example.tuto.entities.Tuteur;

@SuppressWarnings("unused")
@Entity
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tuteur_id", nullable = false)
    private Tuteur tuteur;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @ManyToOne
    @JoinColumn(name = "groupe_id", nullable = false)
    private Groupe groupe;

    @OneToMany(mappedBy = "affectation")
    private List<Seance> seances;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }

    public void setTuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
}
