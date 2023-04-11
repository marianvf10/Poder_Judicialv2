package com.rpcwebservice.services;

import com.rpcwebservice.dtos.RubricaDTO;
import com.rpcwebservice.repositories.RubricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RubricaService {

    @Autowired
    RubricaRepository rubricaRepository;

    @Transactional
    public List<RubricaDTO> getSociedadRubricasById(Integer id){
        return rubricaRepository.findBySociedadId(id);
    }
}
