package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="socios")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "cantidad_participacion")
    private Long cantidad_participacion;

    @Getter
    @Setter
    @Column(name = "cantidad_participacion_inicial")
    private Long cantidad_participacion_inicial;

    @Getter
    @Setter
    @Column(name = "otra_participacion")
    private String otra_participacion ;

    @Getter
    @Setter
    @Column(name = "estado_civil")
    private String estado_civil ;

    @Getter
    @Setter
    @Column(name = "observaciones")
    private String observaciones ;

    @Getter
    @Setter
    @Column(name = "edad")
    private Integer edad ;

    @Getter
    @Setter
    @Column(name = "nombre_conyuge")
    private String nombre_conyuge;

    @Getter
    @Setter
    @Column(name = "apellido_conyuge")
    private String apellido_conyuge;

    @Getter
    @Setter
    @Column(name = "cuit_conyuge")
    private String cuit_conyuge;

    @Getter
    @Setter
    @Column(name = "activo", columnDefinition = "BOOLEAN")
    private Boolean activo;

    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "fecha_baja")
    private Date fecha_baja;

    @Getter
    @Setter
    @Column(name = "legacy_id")
    private Integer legacy_id;

    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_at;

    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "deleted_at")
    private Date deleted_at;

    @Getter
    @Setter
    @Column(name="create_user")
    private String create_user;
    @Getter
    @Setter
    @Column(name="update_user")
    private String update_user;
    @Getter
    @Setter
    @Column(name="delete_user")
    private String delete_user;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona_juridica", nullable = false)
    private PersonaJuridica personaJuridica;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sociedad", nullable = false)
    private Sociedad sociedad ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_participacion", nullable = false)
    private TipoParticipacion tipoParticipacion;

    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }
    @JsonBackReference
    public PersonaJuridica getPersonaJuridica(){
        return personaJuridica;
    }

    @JsonBackReference
    public Sociedad getSociedad(){
        return sociedad;
    }
    @JsonBackReference
    public TipoParticipacion getTipoParticipacion(){
        return tipoParticipacion;
    }



}
