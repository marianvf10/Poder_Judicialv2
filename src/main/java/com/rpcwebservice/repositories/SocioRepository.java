package com.rpcwebservice.repositories;

import com.rpcwebservice.entities.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio,Integer> {
}
