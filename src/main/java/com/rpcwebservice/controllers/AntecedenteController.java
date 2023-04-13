package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.AntecedenteDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.AntecedenteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AntecedenteController {

    @Autowired
    private AntecedenteServiceImp antecedenteServiceImp;

    @GetMapping("/sociedad_antecedentes/{cuit}")
    public ResponseEntity<?> getSociedadAntecedenteByCuit(@PathVariable("cuit") String cuit) {
        List<AntecedenteDTO> antecedentes;
        try {
            antecedentes = antecedenteServiceImp.getSociedadAntecedenteByCuit(cuit);
        } catch (ResourceNotFoundException r) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(r.getMessage());
        }
        return ResponseEntity.ok().body(antecedentes);
    }
}