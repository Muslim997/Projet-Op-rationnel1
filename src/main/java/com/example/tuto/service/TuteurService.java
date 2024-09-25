package com.example.tuto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuto.entities.Tuteur;
import com.example.tuto.repository.TuteurRepository;

@Service
public class TuteurService {
	
		@Autowired
		TuteurRepository tuteurRepository;
		
		
		public Tuteur saveTuteur(Tuteur tuteur) {
			return tuteurRepository.save(tuteur);
		}


		public void updateTuteur(Tuteur tuteur, Long id) {
			tuteurRepository.save(tuteur);
		}
		
		public void deleteTuteur(Long id) {
			tuteurRepository.deleteById(id);
		}
		
		public Tuteur getTuteur(Long id) {
			return tuteurRepository.findById(id).get();
		}
		
		public List<Tuteur> getAllTuteurs() {
			List<Tuteur> tuteurs = new ArrayList<>();
			tuteurRepository.findAll().forEach(tuteur -> tuteurs.add(tuteur));
			return tuteurs;
		}

}
