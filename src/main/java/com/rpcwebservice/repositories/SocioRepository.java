package com.rpcwebservice.repositories;

import com.rpcwebservice.dtos.SocioDTO;
import com.rpcwebservice.entities.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocioRepository extends JpaRepository<Socio,Integer> {
    List<SocioDTO> getSociosBySociedadCuitAndActivo(String cuit,Boolean activo);
}
