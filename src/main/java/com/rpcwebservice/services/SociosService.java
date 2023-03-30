package com.rpcwebservice.services;

import com.rpcwebservice.entities.Socio;

import java.util.List;
import java.util.Optional;

public interface SociosService {

    public List<Socio> getAllSocios();

    Optional<Socio> getSocioPorId(Integer id);
}
