package com.rpcwebservice.controllers;

import com.rpcwebservice.entities.Provincia;
import com.rpcwebservice.repositories.ProvinciaRepository;
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
public class ProvinciaController {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @GetMapping("/provinces")
    public ResponseEntity<List<Provincia>> getAllProvinces(){
        List<Provincia> provinces = new ArrayList<Provincia>();

        provinciaRepository.findAll().forEach(provinces::add);

        if (provinces.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }
}
