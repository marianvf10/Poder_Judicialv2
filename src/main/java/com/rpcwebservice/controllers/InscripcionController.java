package com.rpcwebservice.controllers;

import com.rpcwebservice.entities.Inscripcion;
import com.rpcwebservice.repositories.InscripcionRepository;
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
public class InscripcionController {

    @Autowired
    private InscripcionRepository inscripcionRepository;
    @GetMapping("/inscripciones")
    public ResponseEntity<List<Inscripcion>> getAllInscripciones(){
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

        inscripcionRepository.findAll().forEach(inscripciones::add);

        if (inscripciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(inscripciones, HttpStatus.OK);
    }

}
