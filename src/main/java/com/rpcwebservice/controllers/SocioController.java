package com.rpcwebservice.controllers;

import com.rpcwebservice.entities.Socio;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.SociosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SocioController {

    @Autowired
    private SociosService sociosService;
    @GetMapping("/socios")
    public ResponseEntity<List<Socio>> getAllSocios(){
        List<Socio> socios = new ArrayList<Socio>();
        //comentario prueba

        //sociosService.getAllSocios().forEach(socios::add);

        if (socios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(socios, HttpStatus.OK);
    }

    /*@GetMapping("/socios/{id}")
    public ResponseEntity<Socio> getSocioById(@PathVariable("id") Integer id){
        Socio socio= sociosService.getSocioPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found socio with id: "+id));
        return new ResponseEntity<>(socio, HttpStatus.OK);
    }*/

}
