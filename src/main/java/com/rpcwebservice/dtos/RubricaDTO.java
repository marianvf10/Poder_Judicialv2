package com.rpcwebservice.dtos;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface RubricaDTO {
    /*Interfaz utilizada para proyectar solo atributos que se requieren en el servicio*/
    /*@Value es para seleccionar el atributo que deseamos renombrar*/
    String getNumero_apertura();

    String getNumero_clausura();

    @Value("#{target.apertura}")
    Date getFecha_apertura();

    @Value("#{target.denominacion}")
    String getRu_Denominacion();

    @Value("#{target.sociedad.id}")
    Integer getSociedadId();
}
