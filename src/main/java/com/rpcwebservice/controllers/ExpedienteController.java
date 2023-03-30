package com.rpcwebservice.controllers;

import com.rpcwebservice.entities.Expediente;
import com.rpcwebservice.repositories.ExpedienteRepository;
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
public class ExpedienteController {
    @Autowired
    private ExpedienteRepository expedienteRepository;
    @GetMapping("/expedientes")
    public ResponseEntity<List<Expediente>> getAllExpedientes(){
        List<Expediente> expedientes = new ArrayList<Expediente>();

        expedienteRepository.findAll().forEach(expedientes::add);

        if (expedientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(expedientes, HttpStatus.OK);
    }
}
