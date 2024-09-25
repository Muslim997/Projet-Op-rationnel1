package com.example.tuto.controller;

import com.example.tuto.entities.Module;
import com.example.tuto.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules") // Base URL pour toutes les routes de ce contrôleur
public class moduleController {

    @Autowired
    private ModuleService moduleService;

    // Route pour obtenir tous les modules
    @GetMapping
    public List<Module> getAllModules() {
        return moduleService.getAllModule();
    }

    // Route pour obtenir un module par ID
    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Module module = moduleService.getModule(id);
        return module != null ? ResponseEntity.ok(module) : ResponseEntity.notFound().build();
    }

    // Route pour ajouter un nouveau module
    @PostMapping
    public ResponseEntity<Module> addModule(@RequestBody Module module) {
        moduleService.addModule(module);
        return ResponseEntity.status(201).body(module);
    }

    // Route pour mettre à jour un module existant
    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module) {
        Module existingModule = moduleService.getModule(id);
        if (existingModule != null) {
            module.setId(id); // Assurez-vous que l'ID est mis à jour
            moduleService.updateModule(module, id);
            return ResponseEntity.ok(module);
        }
        return ResponseEntity.notFound().build();
    }

    // Route pour supprimer un module
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        if (moduleService.getModule(id) != null) {
            moduleService.deleteModule(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
