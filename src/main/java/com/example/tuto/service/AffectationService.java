package com.example.tuto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuto.entities.Affectation;
import com.example.tuto.repository.AffectationRepository;

@Service
public class AffectationService {
	
	@Autowired
	AffectationRepository affectationRepository;
	
	// Obtenir la liste des tuteurs
	public List<Affectation> getAllAffectations(){
		List<Affectation> affectations = new ArrayList<>();
		affectationRepository.findAll().forEach(affectation -> affectations.add(affectation));
		return affectations;
	}

	// Obtenir la ligne d'un seul tuteur
	public Affectation getAffectation(Long id) {
		return affectationRepository.findById(id).orElse(null);
	}

	// Ajouter un tuteur
	public void addAffectation(Affectation affectation) {
		affectationRepository.save(affectation);
	}

	
	// Mettre a jour les info d'un tuteurs

	public void updateAffectation(Affectation affectation,Long id) {
		affectationRepository.save(affectation);
	}

	
	// Supprimer un tuteur
	public void deleteAffectation(Long id) {
		affectationRepository.deleteById(id);
	}

}
