package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.SocioDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.SociosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class SocioController {

    /*
    @Autowired
    private SociosService sociosService;
    @GetMapping("/sociedad_socios/{cuit}")
    public ResponseEntity<?> getSocioBySociedadCuit(@PathVariable("cuit")String cuit){
        List<SocioDTO> socios;
        try {
            socios = sociosService.getSociosByCuitSociedad(cuit);
        } catch (ResourceNotFoundException r) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(r.getMessage());
        }
        return ResponseEntity.ok().body(socios);
    }
    */

}
