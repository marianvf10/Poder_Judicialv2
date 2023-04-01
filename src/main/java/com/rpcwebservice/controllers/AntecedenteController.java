package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.AntecedenteDTO;
import com.rpcwebservice.services.AntecedenteService;
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
    private AntecedenteService antecedenteService;

    @GetMapping("/sociedad_antecedentes/{id}")
    public ResponseEntity<List<AntecedenteDTO>> getSociedadAntecedenteById(@PathVariable("id") Integer id){

        List<AntecedenteDTO> antecedentes = antecedenteService.getSociedadAntecedenteById(id);
        if (antecedentes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(antecedentes, HttpStatus.OK);
    }

}
