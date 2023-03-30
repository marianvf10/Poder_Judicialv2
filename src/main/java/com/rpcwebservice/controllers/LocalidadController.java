package com.rpcwebservice.controllers;

import com.rpcwebservice.entities.Localidad;
import com.rpcwebservice.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LocalidadController {
    @Autowired
    private LocalidadRepository localidadRepository;

    @GetMapping("/localidades")
    public ResponseEntity<List<Localidad>> getAllLocalidades(){
        List<Localidad> localidades = new ArrayList<Localidad>();

        localidadRepository.findAll().forEach(localidades::add);

        if (localidades.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(localidades, HttpStatus.OK);
    }
}
