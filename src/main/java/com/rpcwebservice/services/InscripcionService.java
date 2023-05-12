package com.rpcwebservice.services;

import com.rpcwebservice.dtos.InscripcionySedeDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.repositories.InscripcionRepository;
import com.rpcwebservice.repositories.SedeSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private SedeSocialRepository sedeSocialRepository;


    @Transactional
    public InscripcionySedeDTO getInscripcionySedeBySociedadCuit(String cuit){
        return inscripcionRepository.findFirstByExpedienteSociedadCuitOrderByFechaAsc(cuit);
    }
}
