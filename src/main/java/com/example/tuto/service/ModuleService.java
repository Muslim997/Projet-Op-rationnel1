package com.example.tuto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuto.entities.Module;
import com.example.tuto.repository.ModuleRepository;

@Service
public class ModuleService {
	
	@Autowired
	ModuleRepository moduleRepository;
	
	// Obtenir la liste des Modules
	public List<Module> getAllModule(){
		List<Module> modules = new ArrayList<>();
		moduleRepository.findAll().forEach(module -> modules.add(module));
		return modules;
	}

	// Obtenir la ligne d'un seul Module
	public Module getModule(Long id) {
		return moduleRepository.findById(id).orElse(null);
	}

	// Ajouter un Module
	public void addModule(Module module) {
		moduleRepository.save(module);
	}

	// Mettre a jour les info d'un Module

	public void updateModule(Module module,Long id) {
		moduleRepository.save(module);
	}

	// Supprimer un Module
	public void deleteModule(Long id) {
		moduleRepository.deleteById(id);
	}

}
