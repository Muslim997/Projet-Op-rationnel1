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
	
	// Obtenir la liste des tuteurs
	public List<Seance> getAllSeances(){
		List<Seance> seances = new ArrayList<>();
		seanceRepository.findAll().forEach(seance -> seances.add(seance));
		return seances;
	}

	// Obtenir la ligne d'un seul tuteur
	public Seance getSeance(Long id) {
		return seanceRepository.findById(id).orElse(null);
	}

	// Ajouter un tuteur
	public void addSeance(Seance seance) {
		seanceRepository.save(seance);
	}

	// Mettre a jour les info d'un tuteurs

	public void updateSeance(Seance seance,Long id) {
		seanceRepository.save(seance);
	}

	// Supprimer un tuteur
	public void deleteSeance(Long id) {
		seanceRepository.deleteById(id);
	}

}
