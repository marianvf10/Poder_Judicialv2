package com.rpcwebservice.services;

import com.rpcwebservice.dtos.AntecedenteDTO;

import java.util.List;

public interface AntecedenteService {
    public List<AntecedenteDTO> getSociedadAntecedenteByCuit(String cuit);
}
