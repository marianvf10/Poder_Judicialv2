package com.rpcwebservice.dtos;

import com.rpcwebservice.entities.Expediente;
import com.rpcwebservice.entities.SedeSocial;
import com.rpcwebservice.entities.Sociedad;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class InscripcionySedeDTO {

    private final Date fechaInscripcion;
    private final Integer numero;
    private final Integer folio_desde;
    private final Integer folio_hasta;
    private final String tomo_numero;
    private final String tomo_anio;

    private final String denominacion;

    private final String cuit;

    private final Date fecha_instrumento;

    private final String siglas;

    private final Integer duracion;
    private final List<SedeSocialDTO> sedesSocialesInfo;


    public InscripcionySedeDTO(Integer numero, Integer folioDesde, Integer folioHasta, String tomoNumero, String tomoAnio, Date fecha, Expediente expediente) {
        this.numero = numero;
        this.folio_desde = folioDesde;
        this.folio_hasta = folioHasta;
        this.tomo_anio = tomoAnio;
        this.tomo_numero = tomoNumero;
        this.fechaInscripcion = fecha;
        Sociedad sc = expediente.getSociedad();
        this.denominacion = sc.getDenominacion();
        this.cuit = sc.getCuit();
        this.fecha_instrumento = sc.getFechaInstrumento();
        this.siglas = sc.getTipoSociedad().getSiglas();
        this.duracion = sc.getDuracion();
        Set<SedeSocial> sedes = sc.getListaSedesSociales();
        List<SedeSocialDTO> sedeSocialDTOS = new LinkedList<>();
        //busca las sedes que tengan validado en true
        for (SedeSocial sedeSocial : sedes) {
            if (sedeSocial.isValidado()) {
                sedeSocialDTOS.add(new SedeSocialDTO(sedeSocial.getCalle(), sedeSocial.getNumero(), sedeSocial.getOtros(), sedeSocial.getLocalidad().getNombre(), sedeSocial.getLocalidad().getProvincia().getNombre()));
            }
        }
        sedesSocialesInfo = sedeSocialDTOS;

    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getFolio_desde() {
        return folio_desde;
    }

    public Integer getFolio_hasta() {
        return folio_hasta;
    }

    public String getTomo_numero() {
        return tomo_numero;
    }

    public String getTomo_anio() {
        return tomo_anio;
    }

    public List<SedeSocialDTO> getSedesSocialesInfo() {
        return sedesSocialesInfo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getCuit() {
        return cuit;
    }

    public Date getFecha_instrumento() {
        return fecha_instrumento;
    }

    public String getSiglas() {
        return siglas;
    }

    public Integer getDuracion() {
        return duracion;
    }
}


