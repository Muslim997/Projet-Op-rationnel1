package com.example.tuto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tuto.entities.Groupe;


@Repository
public interface GroupeRepository  extends CrudRepository<Groupe, Long> {

}
