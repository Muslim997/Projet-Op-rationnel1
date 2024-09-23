package com.example.tuto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tuto.entities.Seance;

@Repository
public interface SeanceRepository extends CrudRepository<Seance, Long> {

}
