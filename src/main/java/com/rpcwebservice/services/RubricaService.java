package com.rpcwebservice.services;

import com.rpcwebservice.dtos.RubricaDTO;

import java.util.List;

public interface RubricaService {
    public List<RubricaDTO> getSociedadRubricasByCuit(String cuit);
}
