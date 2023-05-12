package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.InscripcionySedeDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.InscripcionService;
import com.rpcwebservice.utils.Validador;
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
    public ResponseEntity<InscripcionySedeDTO> getInscripcionSedeSocialByCuitSociedad(@PathVariable("cuit") String cuit) {

        InscripcionySedeDTO inscripcionySedeDTO;
        String cuitFormateado = Validador.validarCuit(cuit);

        inscripcionySedeDTO = inscripcionService.getInscripcionySedeBySociedadCuit(cuitFormateado);
        if (inscripcionySedeDTO == null) {
            throw new ResourceNotFoundException("No se encontro sociedad con el cuit ingresado");
        }
        return new ResponseEntity<>(inscripcionySedeDTO,HttpStatus.OK);

    }
}
