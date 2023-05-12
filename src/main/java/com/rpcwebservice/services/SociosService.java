package com.rpcwebservice.services;

import com.rpcwebservice.dtos.SocioDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SociosService {

    @Autowired
    private SocioRepository socioRepository;
    @Transactional
    public List<SocioDTO> getSociosByCuitSociedad(String cuit){
        return socioRepository.getSociosBySociedadCuitAndActivo(cuit,true);
    }
}
