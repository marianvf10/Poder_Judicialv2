package com.rpcwebservice.dtos;

import com.rpcwebservice.entities.Persona;
import com.rpcwebservice.entities.PersonaJuridica;
import com.rpcwebservice.entities.Sociedad;
import com.rpcwebservice.entities.TipoParticipacion;


public class SocioDTO {
    private final Integer id;
    private final String nombre;
    private final String apellido;
    private final String numero_documento;
    private final String sexo;
    private final String denominacion;
    private final String denopersonajuridica;
    private final String participacion;

    public SocioDTO(Sociedad sociedad, Persona persona, TipoParticipacion tipoParticipacion, PersonaJuridica personaJuridica) {
        this.id = sociedad.getId();
        this.denominacion = sociedad.getDenominacion();
        this.participacion = tipoParticipacion.getNombre();
        if (persona == null) {
            this.nombre = "";
            this.apellido = "";
            this.sexo = "";
            this.numero_documento = "";
        } else {
            this.nombre = persona.getNombre();
            this.apellido = persona.getApellido();
            this.sexo = persona.getSexo();
            this.numero_documento = persona.getNumero_documento();
        }
        if (personaJuridica == null) {
            this.denopersonajuridica = "";
        } else {
            this.denopersonajuridica = personaJuridica.getDenominacion();
        }
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public String getNumeroDocumento() {
        return this.numero_documento;
    }
    public String getSexo() {
        return this.sexo;
    }
    public Integer getSociedadId() {
        return this.id;
    }
    public String getDenominacion() {
        return this.denominacion;
    }
    public String getParticipacion() {
        return this.participacion;
    }
    public String getDeno() {
        return this.denopersonajuridica;
    }
}
