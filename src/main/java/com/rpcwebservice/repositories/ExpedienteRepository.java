package com.rpcwebservice.repositories;

import com.rpcwebservice.entities.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteRepository extends JpaRepository<Expediente,Integer> {

}
