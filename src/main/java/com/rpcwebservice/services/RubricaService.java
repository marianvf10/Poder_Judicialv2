package com.rpcwebservice.services;

import com.rpcwebservice.dtos.RubricaDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.repositories.RubricaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RubricaService  {

    @Autowired
    RubricaRepository rubricaRepository;

    @Transactional
    public List<RubricaDTO> getSociedadRubricasByCuit(String cuit){
        return rubricaRepository.findBySociedadCuit(cuit, Sort.by("apertura").ascending().and(Sort.by("denominacion").ascending()));

    }
}
