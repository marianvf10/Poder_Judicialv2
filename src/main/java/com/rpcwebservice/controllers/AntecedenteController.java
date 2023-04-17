package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.AntecedenteDTO;
import com.rpcwebservice.dtos.RubricaDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.AntecedenteServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Tag(name = "Antecedente", description = "Web Service de Gestion de Antecedentes")
@RequestMapping("/api")
public class AntecedenteController {

    @Autowired
    private AntecedenteServiceImp antecedenteServiceImp;

    @Operation(
            summary = "Recuperar antecedente por medio del cuit de sociedad",
            description = "Obtener un objeto antecedente por medio del cuit de una sociedad. La respuesta es un objeto Antecedente con fecha,descripcion,nombre como tipo de antecedente y descripcion",
            tags = { "Antecedente"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = RubricaDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "No se encontro una sociedad con el cuit ingresado",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/sociedad_antecedentes/{cuit}")
    public ResponseEntity<?> getSociedadAntecedenteByCuit(@PathVariable("cuit") String cuit) {
        List<AntecedenteDTO> antecedentes;
        try {
            antecedentes = antecedenteServiceImp.getSociedadAntecedenteByCuit(cuit);
        } catch (ResourceNotFoundException r) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(r.getMessage());
        }
        return ResponseEntity.ok().body(antecedentes);
    }
}