package com.example.tuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tuto.entities.Groupe;
import com.example.tuto.service.GroupeService;

@RestController
@RequestMapping("/api/groupes") // Base URL pour toutes les routes de ce contrôleur
public class groupeController {

	@Autowired
    private GroupeService groupeService;

    // Route pour obtenir tous les Groupes
    @GetMapping
    public List<Groupe> getAllGroupes() {
        return groupeService.getAllGroupes();
    }

    // Route pour obtenir un Groupe par ID
    @GetMapping("/{id}")
    public ResponseEntity<Groupe> getGroupeById(@PathVariable Long id) {
    	Groupe groupe = groupeService.getGroupe(id);
        return groupe != null ? ResponseEntity.ok(groupe) : ResponseEntity.notFound().build();
    }

    // Route pour ajouter un nouveau Groupe
    @PostMapping
    public ResponseEntity<Groupe> addGroupe(@RequestBody Groupe groupe) {
    	groupeService.addGroupe(groupe);
        return ResponseEntity.status(201).body(groupe);
    }

    // Route pour mettre à jour un Groupe existant
    @PutMapping("/{id}")
    public ResponseEntity<Groupe> updateGoupe(@PathVariable Long id, @RequestBody Groupe groupe) {
        Groupe existingGroupe = groupeService.getGroupe(id);
        if (existingGroupe != null) {
            groupe.setId(id); // Assure que l'ID est mis à jour
            groupeService.updateGroupe(groupe, id);
            return ResponseEntity.ok(groupe);
        }
        return ResponseEntity.notFound().build();
    }

    // Route pour supprimer un Groupe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupe(@PathVariable Long id) {
        if (groupeService.getGroupe(id) != null) {
        	groupeService.deleteGroupe(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
