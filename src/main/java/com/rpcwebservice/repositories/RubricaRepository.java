package com.rpcwebservice.repositories;

import com.rpcwebservice.dtos.RubricaDTO;
import com.rpcwebservice.entities.Rubrica;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RubricaRepository extends CrudRepository<Rubrica,Integer> {

    List<RubricaDTO> findBySociedadCuit(String cuit, Sort sort);
}
