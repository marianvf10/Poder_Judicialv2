package com.rpcwebservice.dtos;

public class SedeSocialDTO {

    String calle;
    String numeroSedeSocial;
    String observaciones;

    String localidad;

    String provincia;

    public SedeSocialDTO(String calle, String numeroSedeSocial, String observaciones, String localidad, String provincia) {
        this.calle = calle;
        this.numeroSedeSocial = numeroSedeSocial;
        this.observaciones = observaciones;
        this.localidad = localidad;
        this.provincia = provincia;
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

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }
}
