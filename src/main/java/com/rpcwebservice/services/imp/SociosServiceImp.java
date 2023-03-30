package com.rpcwebservice.services.imp;

import com.rpcwebservice.entities.Socio;
import com.rpcwebservice.repositories.SocioRepository;
import com.rpcwebservice.services.SociosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SociosServiceImp implements SociosService {

    @Autowired
    private SocioRepository socioRepository;

    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    public Optional<Socio> getSocioPorId(Integer id){
        return socioRepository.findById(id);
    }


}
