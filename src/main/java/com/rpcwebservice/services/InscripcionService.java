package com.rpcwebservice.services;

import com.rpcwebservice.dtos.InscripcionySedeDTO;
import com.rpcwebservice.entities.Inscripcion;
import com.rpcwebservice.entities.SedeSocial;
import com.rpcwebservice.entities.Sociedad;
import com.rpcwebservice.repositories.InscripcionRepository;
import com.rpcwebservice.repositories.SedeSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private SedeSocialRepository sedeSocialRepository;

    @Transactional
    public InscripcionySedeDTO getInscripcionySedeBySociedadCuit(String cuit){
        //Utilice dos repositorios porque no encontre una forma de hacer un join con los datos de solo un repositorio
        Inscripcion inscripcion = inscripcionRepository.findFirstByExpedienteSociedadCuitOrderByFechaAsc(cuit);
        SedeSocial sedeSocial = sedeSocialRepository.findBySociedadCuitAndValidado(cuit,true);
        Sociedad sociedad = sedeSocial.getSociedad();
        return data2DTO(cuit,inscripcion,sedeSocial,sociedad);

    }
    private InscripcionySedeDTO data2DTO(String cuit,Inscripcion inscripcion, SedeSocial sedeSocial, Sociedad sociedad){
        String denominacion = sociedad.getDenominacion();
        Date fecha_instrumento = sociedad.getFecha_instrumento();
        String tipoSociedad = sedeSocial.getSociedad().getTipoSociedad().getSiglas();
        Integer idSedeSocial = sedeSocial.getId();
        Date fechaInscripcion = inscripcion.getFecha();
        Integer numero = inscripcion.getNumero();
        Integer folio_desde = inscripcion.getFolio_desde();
        Integer folio_hasta = inscripcion.getFolio_hasta();
        String tomo_numero = inscripcion.getTomo_numero();
        String tomo_anio = inscripcion.getTomo_anio();
        String calle = sedeSocial.getCalle();
        String numeroSedeSocial = sedeSocial.getNumero();
        String observaciones = sedeSocial.getOtros();
        return new InscripcionySedeDTO(denominacion,cuit,tipoSociedad,fecha_instrumento,
                idSedeSocial,fechaInscripcion,numero,folio_desde,folio_hasta,tomo_numero,tomo_anio,
                calle,numeroSedeSocial,observaciones);
    }
}
