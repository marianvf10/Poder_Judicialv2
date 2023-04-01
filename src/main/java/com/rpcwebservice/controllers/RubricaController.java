package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.RubricaDTO;
import com.rpcwebservice.services.RubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RubricaController {

    @Autowired
    private RubricaService rubricaService;
    @GetMapping("/sociedad_rubricas/{id}")
    public ResponseEntity<List<RubricaDTO>> getRubricasConSociedad(@PathVariable("id") Integer id){
        List<RubricaDTO> rubricasDTOS = rubricaService.getSociedadRubricasById(id);

        if (rubricasDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rubricasDTOS, HttpStatus.OK);
    }
}
