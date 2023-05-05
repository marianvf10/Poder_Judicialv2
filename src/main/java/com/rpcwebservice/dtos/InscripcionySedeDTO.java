package com.rpcwebservice.dtos;

import java.util.Date;

public class InscripcionySedeDTO {

    private final String denominacion;
    private final String cuit;
    private final String TipoSociedad;
    private final Date fecha_instrumento;
    private final Integer idSedeSocial;
    private final Date fechaInscripcion;
    private final Integer numero;
    private final Integer folio_desde;
    private final Integer folio_hasta;
    private final String tomo_numero;
    private final String tomo_anio;
    private final String calle;
    private final String numeroSedeSocial;
    private final String observaciones;

    public InscripcionySedeDTO(String denominacion, String cuit, String TipoSociedad, Date fecha_instrumento, Integer idSedeSocial, Date fechaInscripcion, Integer numero, Integer folio_desde, Integer folio_hasta, String tomo_numero, String tomo_anio, String calle, String numeroSedeSocial, String observaciones) {
        this.denominacion = denominacion;
        this.cuit = cuit;
        this.TipoSociedad = TipoSociedad;
        this.fecha_instrumento = fecha_instrumento;
        this.idSedeSocial = idSedeSocial;
        this.fechaInscripcion = fechaInscripcion;
        this.numero = numero;
        this.folio_desde = folio_desde;
        this.folio_hasta = folio_hasta;
        this.tomo_numero = tomo_numero;
        this.tomo_anio = tomo_anio;
        this.calle = calle;
        this.numeroSedeSocial = numeroSedeSocial;
        this.observaciones = observaciones;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getCuit() {
        return cuit;
    }

    public String getTipoSociedad() {
        return TipoSociedad;
    }

    public Date getFecha_instrumento() {
        return fecha_instrumento;
    }

    public Integer getIdSedeSocial() {
        return idSedeSocial;
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

    public String getCalle() {
        return calle;
    }

    public String getNumeroSedeSocial() {
        return numeroSedeSocial;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
