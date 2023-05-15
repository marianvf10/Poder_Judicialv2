package com.rpcwebservice.controllers;

import com.rpcwebservice.dtos.InscripcionySedeDTO;
import com.rpcwebservice.exceptions.ResourceNotFoundException;
import com.rpcwebservice.services.InscripcionService;
import com.rpcwebservice.utils.Validador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;
    @Operation(
            summary = "Recuperar informacion de inscripcion y sede por medio del cuit de sociedad",
            description = "Obtener un objeto inscripcion por medio del cuit de una sociedad. La respuesta es un objeto Inscripcion con fecha inscripcion,numero,folio desde" +
                    "folio hasta,tomo numero,tomo anio,denominacion,cuit,fecha instrumento,siglas,duracion e informacion correspondiente" +
                    "a la sede social la cual incluye calle,numero, observaciones, localidad y provincia",
            tags = { "Inscripcion"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = InscripcionySedeDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "El cuit ingresado no es valido",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "No se encontro una sociedad con el cuit ingresado",content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",content = { @Content(schema = @Schema()) })
    })
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
