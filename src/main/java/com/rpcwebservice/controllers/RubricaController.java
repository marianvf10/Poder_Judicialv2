package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.RubricaDTO;
//import com.rpcwebservice.dtos.RubricasDT;
//import com.rpcwebservice.entities.Rubrica;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.RubricaService;
import com.rpcwebservice.utils.Validador;
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

@Tag(name = "Rubrica", description = "Web Service de Gestion de Rubricas")
@RestController
@RequestMapping("/api")
public class RubricaController {

    @Autowired
    private RubricaService rubricaService;
    @Operation(
            summary = "Recuperar rubrica por medio del cuit de sociedad",
            description = "Obtener un objeto rubrica por medio del cuit de una sociedad. La respuesta es un objeto Rubrica con numero apertura, numero clausura, ru denominacion,id de sociedad y fecha apertura",
            tags = {"Rubrica"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = RubricaDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "No se encontro una sociedad con el cuit ingresado", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", description = "El cuit ingresado no es valido", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = {@Content(schema = @Schema())})
    })
    @GetMapping("/sociedad_rubricas/{cuit}")
    public ResponseEntity<List<RubricaDTO>> getRubricasConSociedad(@PathVariable("cuit") String cuit) {
        List<RubricaDTO> rubricas;

        String cuitFormateado = Validador.validarCuit(cuit);
        rubricas = rubricaService.getSociedadRubricasByCuit(cuitFormateado);
        if (rubricas.isEmpty()) {
            throw new ResourceNotFoundException("No se encontro sociedad con el cuit ingresado");
        }
           return new ResponseEntity<>(rubricas,HttpStatus.OK);
        }

    }

