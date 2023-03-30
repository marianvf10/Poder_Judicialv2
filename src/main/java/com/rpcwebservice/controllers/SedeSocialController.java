package com.rpcwebservice.controllers;

import com.rpcwebservice.entities.SedeSocial;
import com.rpcwebservice.repositories.SedeSocialRepository;
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
public class SedeSocialController {
    @Autowired
    private SedeSocialRepository sedeSocialRepository;

    @GetMapping("/sedessociales")
    public ResponseEntity<List<SedeSocial>> getAllSedes(){
        List<SedeSocial> sedes = new ArrayList<SedeSocial>();

        sedeSocialRepository.findAll().forEach(sedes::add);

        if (sedes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(sedes, HttpStatus.OK);
    }
}
