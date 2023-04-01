package com.rpcwebservice.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface AntecedenteDTO {
    String getFecha();

    String getDescripcion();

    @Value("#{target.tipoAntecedente.nombre}")
    String getTipoAntecedente();

    @Value("#{target.inscripcion.numero + '/' + target.inscripcion.tomo_anio}")
    String getInscripcion();

    @Value("#{target.sociedad.id}")
    String getIdSociedad();
}
