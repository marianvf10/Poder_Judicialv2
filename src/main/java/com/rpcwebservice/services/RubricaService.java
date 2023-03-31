package com.rpcwebservice.services;

import com.rpcwebservice.repositories.RubricaRepository;
import com.rpcwebservice.dtos.RubricasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RubricaService {

    @Autowired
    RubricaRepository rubricaRepository;

    @Transactional
    public List<RubricasDTO> obtenerRubricasConSociedades(@Param("idSociedad") Integer idSociedad){
        return rubricaRepository.buscarRubricasConSociedades(idSociedad);
    }

}
