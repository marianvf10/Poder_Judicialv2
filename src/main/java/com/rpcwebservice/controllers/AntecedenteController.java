package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.AntecedenteDTO;
import com.rpcwebservice.dtos.RubricaDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.AntecedenteService;
import com.rpcwebservice.utils.Validador;
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

@RestController
@Tag(name = "Antecedente", description = "Web Service de Gestion de Antecedentes")
@RequestMapping("/api")
public class AntecedenteController {

    @Autowired
    private AntecedenteService antecedenteService;

    @Operation(
            summary = "Recuperar antecedente por medio del cuit de sociedad",
            description = "Obtener un objeto antecedente por medio del cuit de una sociedad. La respuesta es un objeto Antecedente con fecha,descripcion,nombre como tipo de antecedente y descripcion",
            tags = { "Antecedente"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = RubricaDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "El cuit ingresado no es valido",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "No se encontro una sociedad con el cuit ingresado",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/sociedad_antecedentes/{cuit}")
    public ResponseEntity<?> getSociedadAntecedenteByCuit(@PathVariable("cuit") String cuit) {
        List<AntecedenteDTO> antecedentes;
        String cuitFormateado = Validador.validarCuit(cuit);
        if (!cuitFormateado.isEmpty()){
            try {
                antecedentes = antecedenteService.getSociedadAntecedenteByCuit(cuitFormateado);
            } catch (ResourceNotFoundException r) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(r.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El cuit ingresado es invalido");
        }

        return ResponseEntity.ok().body(antecedentes);
    }
}