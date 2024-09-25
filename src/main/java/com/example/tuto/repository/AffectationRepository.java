package com.example.tuto.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tuto.entities.Affectation;

@Repository
public interface AffectationRepository extends CrudRepository<Affectation, Long> {
}
