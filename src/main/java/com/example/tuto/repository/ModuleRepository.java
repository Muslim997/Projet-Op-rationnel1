package com.example.tuto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tuto.entities.Module;

@Repository
public interface ModuleRepository  extends CrudRepository<Module, Long>  {

}
