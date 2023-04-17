package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.RubricaDTO;
//import com.rpcwebservice.dtos.RubricasDT;
//import com.rpcwebservice.entities.Rubrica;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.RubricaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Tag(name = "Rubrica", description = "Web Service de Gestion de Rubricas")
@RestController
@RequestMapping("/api")
public class RubricaController {

    @Autowired
    private RubricaService rubricaService;
    @Operation(
            summary = "Recuperar rubrica por medio del cuit de sociedad",
            description = "Obtener un objeto rubrica por medio del cuit de una sociedad. La respuesta es un objeto Rubrica con numero apertura, numero clausura, ru denominacion,id de sociedad y fecha apertura",
            tags = { "Rubrica"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = RubricaDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "No se encontro una sociedad con el cuit ingresado",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/sociedad_rubricas/{cuit}")
    public ResponseEntity<?> getRubricasConSociedad(@PathVariable("cuit") String cuit){
        List<RubricaDTO> rubricas;
        try {
            rubricas = rubricaService.getSociedadRubricasByCuit(cuit);
        } catch (ResourceNotFoundException r) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(r.getMessage());
        }
        return ResponseEntity.ok().body(rubricas);
    }
}
