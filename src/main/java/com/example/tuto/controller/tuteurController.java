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

import com.example.tuto.entities.Tuteur;
import com.example.tuto.service.TuteurService;

@RestController
@RequestMapping("/api/tuteurs") // Base URL pour toutes les routes de ce contrôleur
public class tuteurController {
	
	 @Autowired
	    private TuteurService tuteurService;

	    // Route pour obtenir tous les Tuteurs
	    @GetMapping
	    public List<Tuteur> getAllTuteurs() {
	        return tuteurService.getAllTuteurs();
	    }

	    // Route pour obtenir un Tuteur par ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Tuteur> getTuteurById(@PathVariable Long id) {
	        Tuteur tuteur = tuteurService.getTuteur(id);
	        return tuteur != null ? ResponseEntity.ok(tuteur) : ResponseEntity.notFound().build();
	    }

	    // Route pour ajouter un nouveau Tuteur
	    @PostMapping
	    public ResponseEntity<Tuteur> addTuteur(@RequestBody Tuteur tuteur) {
	    	tuteurService.saveTuteur(tuteur);
	        return ResponseEntity.status(201).body(tuteur);
	    }

	    // Route pour mettre à jour un Tuteur existant
	    @PutMapping("/{id}")
	    public ResponseEntity<Tuteur> updateTuteur(@PathVariable Long id, @RequestBody Tuteur tuteur) {
	        Tuteur existingTuteur = tuteurService.getTuteur(id);
	        if (existingTuteur != null) {
	            tuteur.setId(id); // Assure que l'ID est mis à jour
	            tuteurService.updateTuteur(tuteur, id);
	            return ResponseEntity.ok(tuteur);
	        }
	        return ResponseEntity.notFound().build();
	    }

	    // Route pour supprimer un Tuteur
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTuteur(@PathVariable Long id) {
	        if (tuteurService.getTuteur(id) != null) {
	        	tuteurService.deleteTuteur(id);
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.notFound().build();
	    }

}
