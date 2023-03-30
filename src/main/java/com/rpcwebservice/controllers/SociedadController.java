package com.rpcwebservice.controllers;

import com.rpcwebservice.entities.Sociedad;
import com.rpcwebservice.repositories.SociedadRepository;
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
public class SociedadController {

    @Autowired
    private SociedadRepository sociedadRepository;
    @GetMapping("/sociedades")
    public ResponseEntity<List<Sociedad>> getAllSociedades(){
        List<Sociedad> sociedades = new ArrayList<Sociedad>();

        sociedadRepository.findAll().forEach(sociedades::add);

        if (sociedades.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(sociedades, HttpStatus.OK);
    }
}
