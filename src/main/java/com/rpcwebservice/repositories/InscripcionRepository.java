package com.rpcwebservice.repositories;

import com.rpcwebservice.dtos.InscripcionySedeDTO;
import com.rpcwebservice.entities.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InscripcionRepository extends JpaRepository<Inscripcion,Integer> {
    InscripcionySedeDTO findFirstByExpedienteSociedadCuitOrderByFechaAsc(String cuit);

}
