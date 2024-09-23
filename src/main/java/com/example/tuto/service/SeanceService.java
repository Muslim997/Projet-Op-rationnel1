package com.example.tuto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuto.entities.Seance;
import com.example.tuto.repository.SeanceRepository;

@Service
public class SeanceService {
	
	@Autowired
	SeanceRepository seanceRepository;
	
	// Obtenir la liste des Seances
	public List<Seance> getAllSeances(){
		List<Seance> seances = new ArrayList<>();
		seanceRepository.findAll().forEach(seance -> seances.add(seance));
		return seances;
	}

	// Obtenir la ligne d'une seule Seance
	public Seance getSeance(Long id) {
		return seanceRepository.findById(id).orElse(null);
	}

	// Ajouter une Seance
	public void addSeance(Seance seance) {
		seanceRepository.save(seance);
	}

	// Mettre a jour les info d'une Seance

	public void updateSeance(Seance seance,Long id) {
		seanceRepository.save(seance);
	}

	// Supprimer une Seance
	public void deleteSeance(Long id) {
		seanceRepository.deleteById(id);
	}

}
