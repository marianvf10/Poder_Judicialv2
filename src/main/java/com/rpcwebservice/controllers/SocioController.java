package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.SocioDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.SociosService;
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

@Tag(name = "Socio", description = "Web Service de Gestion de Socios")
@RestController
@RequestMapping("/api")
public class SocioController {

    @Autowired
    private SociosService sociosService;
    @Operation(
            summary = "Recuperar socio por medio del cuit de sociedad",
            description = "Obtener un objeto socio por medio del cuit de una sociedad. La respuesta es un objeto Socio con nombre,apellido,sexo,denominacion,participacion,id de sociedad,numero documento y deno",
            tags = { "Socio"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SocioDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "El cuit ingresado no es valido",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "No se encontro una sociedad con el cuit ingresado",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/sociedad_socios/{cuit}")
    public ResponseEntity<?> getSocioBySociedadCuit(@PathVariable("cuit")String cuit){
        List<SocioDTO> socios;
        String cuitFormateado = Validador.validarCuit(cuit);

        socios = sociosService.getSociosByCuitSociedad(cuitFormateado);
        if (socios.isEmpty()) {
            throw new ResourceNotFoundException("No se encontro sociedad con el cuit ingresado");
        }
        return new ResponseEntity<>(socios,HttpStatus.OK);
    }

}
