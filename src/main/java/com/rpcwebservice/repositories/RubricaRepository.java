package com.rpcwebservice.repositories;

import com.rpcwebservice.dtos.RubricaDTO;
import com.rpcwebservice.entities.Rubrica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RubricaRepository extends CrudRepository<Rubrica,Integer> {

    List<RubricaDTO> findBySociedadId(Integer id);

}
