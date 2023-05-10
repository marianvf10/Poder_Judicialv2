package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.InscripcionySedeDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;
    @GetMapping("/sociedad_inscripcion_sedesocial/{cuit}")
    public ResponseEntity<?> getInscripcionSedeSocialByCuitSociedad(@PathVariable("cuit") String cuit) {

        InscripcionySedeDTO inscripcionySedeDTO;

        try {
            inscripcionySedeDTO = inscripcionService.getInscripcionySedeBySociedadCuit(cuit);
        } catch (ResourceNotFoundException r) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(r.getMessage());
        }
        return ResponseEntity.ok().body(inscripcionySedeDTO);
    }
}
