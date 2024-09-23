package com.example.tuto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tuto.entities.Tuteur;

@Repository
public interface TuteurRepository extends CrudRepository<Tuteur, Long> {

}
