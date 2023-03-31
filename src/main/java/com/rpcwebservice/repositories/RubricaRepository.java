package com.rpcwebservice.repositories;

import com.rpcwebservice.entities.Rubrica;
import com.rpcwebservice.dtos.RubricasDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RubricaRepository extends JpaRepository<Rubrica,Integer> {

    @Query(name="buscarRubricaConSociedad", nativeQuery = true)
    List<RubricasDTO> buscarRubricasConSociedades(@Param("idSociedad") Integer idSociedad);

}
