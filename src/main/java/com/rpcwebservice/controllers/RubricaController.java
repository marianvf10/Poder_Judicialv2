package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.RubricasDTO;
import com.rpcwebservice.entities.Sociedad;
import com.rpcwebservice.repositories.SociedadRepository;
import com.rpcwebservice.services.RubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RubricaController {

    @Autowired
    private RubricaService rubricaService;
    @GetMapping("/rubricas")
    public ResponseEntity<List<RubricasDTO>> getRubricasConSociedad(@Param("idSociedad") Integer idSociedad){
        List<RubricasDTO> rubricasDTOS;

        rubricasDTOS = rubricaService.obtenerRubricasConSociedades(idSociedad);

        if (rubricasDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rubricasDTOS, HttpStatus.OK);
    }
}
