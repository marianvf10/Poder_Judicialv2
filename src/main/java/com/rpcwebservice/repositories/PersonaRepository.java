package com.rpcwebservice.repositories;

import com.rpcwebservice.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {

}
