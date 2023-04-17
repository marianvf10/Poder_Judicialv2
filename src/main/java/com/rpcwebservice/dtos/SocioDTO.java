package com.rpcwebservice.dtos;

import org.springframework.beans.factory.annotation.Value;


public interface SocioDTO {

    @Value("#{target.persona.nombre}")
    String getNombre();

    @Value("#{target.persona.apellido}")
    String getApellido();

    @Value("#{target.persona.numero_documento}")
    String getNumeroDocumento();

    @Value("#{target.persona.sexo}")
    String getSexo();

    @Value("#{target.sociedad.id}")
    Integer getSociedadId();

    @Value("#{target.sociedad.denominacion}")
    String getDenominacion();

    @Value("#{target.tipoParticipacion.nombre}")
    String getParticipacion();








}
