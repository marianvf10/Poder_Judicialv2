package com.rpcwebservice.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface AntecedenteDTO {
    /*Interfaz utilizada para proyectar solo atributos que se requieren en el servicio*/
    /*@Value es para seleccionar el atributo que deseamos renombrar*/
    String getFecha();

    String getDescripcion();

    @Value("#{target.tipoAntecedente.nombre}")
    String getTipoAntecedente();

    @Value("#{target.inscripcion.numero + '/' + target.inscripcion.tomo_anio}")
    String getInscripcion();
}
