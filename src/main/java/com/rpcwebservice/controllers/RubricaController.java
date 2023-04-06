package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.RubricaDTO;
import com.rpcwebservice.entities.Rubrica;
import com.rpcwebservice.services.RubricaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@Tag(name = "Rubrica", description = "API de Gestion de Rubricas")
@RestController
@RequestMapping("/api")
public class RubricaController {

    @Autowired
    private RubricaService rubricaService;
    @Operation(
            summary = "Recuperar rubrica por medio de id de sociedad",
            description = "Obtener un objeto rubrica por medio del id de una sociedad. La respuesta es un objeto Rubrica con numero apertura, numero clausura, ru denominacion,id de sociedad y fecha apertura",
            tags = { "rubricas", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = RubricaDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "No se encontro una sociedad con el id ingresado",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/sociedad_rubricas/{id}")
    public ResponseEntity<List<RubricaDTO>> getRubricasConSociedad(@PathVariable("id") Integer id){
        List<RubricaDTO> rubricasDTOS = rubricaService.getSociedadRubricasById(id);

        if (rubricasDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rubricasDTOS, HttpStatus.OK);
    }
}
