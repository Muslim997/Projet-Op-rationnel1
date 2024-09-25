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

import com.example.tuto.entities.Affectation;
import com.example.tuto.service.AffectationService;

@RestController
@RequestMapping("/api/affectations") // Base URL pour toutes les routes de ce contrôleur
public class affectationController {
	
	 @Autowired
	    private AffectationService affectationService;

	    // Route pour obtenir tous les Affectations
	    @GetMapping
	    public List<Affectation> getAllAffectations() {
	        return affectationService.getAllAffectations();
	    }

	    // Route pour obtenir une Affectation par ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Affectation> getAffectationById(@PathVariable Long id) {
	    	Affectation affectation = affectationService.getAffectation(id);
	        return affectation != null ? ResponseEntity.ok(affectation) : ResponseEntity.notFound().build();
	    }

	    // Route pour ajouter une nouvelle Affectation
	    @PostMapping
	    public ResponseEntity<Affectation> addAffectation(@RequestBody Affectation affectation) {
	    	affectationService.addAffectation(affectation);
	        return ResponseEntity.status(201).body(affectation);
	    }

	    // Route pour mettre à jour une Affectation existant
	    @PutMapping("/{id}")
	    public ResponseEntity<Affectation> updateAffectation(@PathVariable Long id, @RequestBody Affectation affectation) {
	    	Affectation existingAffectation = affectationService.getAffectation(id);
	        if (existingAffectation != null) {
	        	affectation.setId(id); // Assure que l'ID est mis à jour
	            affectationService.updateAffectation(affectation, id);
	            return ResponseEntity.ok(affectation);
	        }
	        return ResponseEntity.notFound().build();
	    }

	    // Route pour supprimer une Affectation
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteAffectation(@PathVariable Long id) {
	        if (affectationService.getAffectation(id) != null) {
	        	affectationService.deleteAffectation(id);
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.notFound().build();
	    }

}
