package com.rpcwebservice.repositories;

import com.rpcwebservice.dtos.AntecedenteDTO;
import com.rpcwebservice.entities.Antecedente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AntecedenteRepository extends JpaRepository<Antecedente,Integer> {

    List<AntecedenteDTO> findBySociedadId(Integer id);

}
