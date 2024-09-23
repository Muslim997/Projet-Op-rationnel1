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

import com.example.tuto.entities.Seance;
import com.example.tuto.service.SeanceService;

@RestController
@RequestMapping("/api/seances") // Base URL pour toutes les routes de ce contrôleur
public class seanceController {
	
	 @Autowired
	    private SeanceService seanceService;

	    // Route pour obtenir tous les Seances
	    @GetMapping
	    public List<Seance> getAllSeances() {
	        return seanceService.getAllSeances();
	    }

	    // Route pour obtenir une Seance par ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Seance> getSeanceById(@PathVariable Long id) {
	        Seance seance = seanceService.getSeance(id);
	        return seance != null ? ResponseEntity.ok(seance) : ResponseEntity.notFound().build();
	    }

	    // Route pour ajouter une nouvelle Seance
	    @PostMapping
	    public ResponseEntity<Seance> addSeance(@RequestBody Seance seance) {
	    	seanceService.addSeance(seance);
	        return ResponseEntity.status(201).body(seance);
	    }

	    // Route pour mettre à jour une Seance existant
	    @PutMapping("/{id}")
	    public ResponseEntity<Seance> updateSeance(@PathVariable Long id, @RequestBody Seance seance) {
	        Seance existingSeance = seanceService.getSeance(id);
	        if (existingSeance != null) {
	            seance.setId(id); // Assure que l'ID est mis à jour
	            seanceService.updateSeance(seance, id);
	            return ResponseEntity.ok(seance);
	        }
	        return ResponseEntity.notFound().build();
	    }

	    // Route pour supprimer une Seance
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
	        if (seanceService.getSeance(id) != null) {
	        	seanceService.deleteSeance(id);
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.notFound().build();
	    }

}
