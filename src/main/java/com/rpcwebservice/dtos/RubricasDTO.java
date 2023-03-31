package com.rpcwebservice.dtos;

public class RubricasDTO {
    private Integer id_sociedad;
    private String Fecha_Apertura;
    private String Ru_denominacion;
    private String numero_apertura;
    private String numero_clausura;

    public RubricasDTO(Integer id_sociedad, String fecha_Apertura, String ru_denominacion, String numero_apertura, String numero_clausura) {
        this.id_sociedad = id_sociedad;
        Fecha_Apertura = fecha_Apertura;
        Ru_denominacion = ru_denominacion;
        this.numero_apertura = numero_apertura;
        this.numero_clausura = numero_clausura;
    }

    public Integer getId_sociedad() {
        return id_sociedad;
    }

    public void setId_sociedad(Integer id_sociedad) {
        this.id_sociedad = id_sociedad;
    }

    public String getFecha_Apertura() {
        return Fecha_Apertura;
    }

    public void setFecha_Apertura(String fecha_Apertura) {
        Fecha_Apertura = fecha_Apertura;
    }

    public String getRu_denominacion() {
        return Ru_denominacion;
    }

    public void setRu_denominacion(String ru_denominacion) {
        Ru_denominacion = ru_denominacion;
    }

    public String getNumero_apertura() {
        return numero_apertura;
    }

    public void setNumero_apertura(String numero_apertura) {
        this.numero_apertura = numero_apertura;
    }

    public String getNumero_clausura() {
        return numero_clausura;
    }

    public void setNumero_clausura(String numero_clausura) {
        this.numero_clausura = numero_clausura;
    }
}
