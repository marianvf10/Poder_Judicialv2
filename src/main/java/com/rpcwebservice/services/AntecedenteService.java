package com.rpcwebservice.services;

import com.rpcwebservice.dtos.AntecedenteDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.repositories.AntecedenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AntecedenteService {

    @Autowired
    AntecedenteRepository antecedenteRepository;

    @Transactional
    public List<AntecedenteDTO> getSociedadAntecedenteByCuit(String cuit){
        return antecedenteRepository.findBySociedadCuitOrderByFecha(cuit);
    }
}
