package com.example.tuto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuto.entities.Groupe;
import com.example.tuto.repository.GroupeRepository;

@Service
public class GroupeService {
	
	@Autowired
	GroupeRepository groupeRepository;
	
	// Obtenir la liste des tuteurs
	public List<Groupe> getAllGroupes(){
		List<Groupe> groupes = new ArrayList<>();
		groupeRepository.findAll().forEach(groupe -> groupes.add(groupe));
		return groupes;
	}

	// Obtenir la ligne d'un seul tuteur
	public Groupe getGroupe(Long id) {
		return groupeRepository.findById(id).orElse(null);
	}

	// Ajouter un tuteur
	public void addGroupe(Groupe groupe) {
		groupeRepository.save(groupe);
	}

	// Mettre a jour les info d'un tuteurs

	public void updateGroupe(Groupe groupe,Long id) {
		groupeRepository.save(groupe);
	}

	// Supprimer un tuteur
	public void deleteGroupe(Long id) {
		groupeRepository.deleteById(id);
	}

}
