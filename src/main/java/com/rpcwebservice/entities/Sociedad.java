package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rpcwebservice.utils.Instrumento;
import com.rpcwebservice.utils.Instrumento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sociedades")
public class Sociedad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name="denominacion")
    private String denominacion;

    @Getter
    @Setter
    @Column(name="cuit")
    private String cuit;

    @Getter
    @Setter
    @Column(name="duracion")
    private Integer duracion;

    @Getter
    @Setter
    @Column(name="observaciones",columnDefinition="TEXT")
    private String observaciones;

    @Getter
    @Setter
    @Column(name="observacion_capital",columnDefinition = "TEXT")
    private String observacion_capital;

    @Getter
    @Setter
    @Column(name="capital")
    private Long capital;

    @Getter
    @Setter
    @Column(name="cantidad_cuotas")
    private Long cantidad_cuotas;

    @Getter
    @Setter
    @Column(name="valor_cuota")
    private Long valor_cuota;

    @Getter
    @Setter
    @Column(name="fondo_comun")
    private Integer fondo_comun;

    @Getter
    @Setter
    @Column(name="aporte")
    private String aporte;

    @Setter
    @Getter
    @Column(name="instrumento")
    private Instrumento instrumento;

    @Getter
    @Setter
    @Column(name="moneda_cuota")
    private String moneda_cuota;

    @Getter
    @Setter
    @Column(name="moneda_capital")
    private String moneda_capital;

    @Getter
    @Setter
    @Column(name="moneda_fondo")
    private String moneda_fondo;

    @Getter
    @Setter
    @Column(name = "articulo61", columnDefinition = "BOOLEAN")
    private Boolean articulo61;

    @Getter
    @Setter
    @Column(name="fojas_articulo61")
    private String fojas_articulo61;

    @Getter
    @Setter
    @Column(name = "plan_cuenta_articulo61", columnDefinition = "BOOLEAN")
    private Boolean plan_cuenta_articulo61;

    @Getter
    @Setter
    @Column(name = "cancelada", columnDefinition = "BOOLEAN")
    private Boolean cancelada;

    @Getter
    @Setter
    @Column(name = "validado", columnDefinition = "BOOLEAN")
    private Boolean validado;

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

    @Getter
    @Setter
    @Column(name="numero_expediente_rubrica")
    private String numero_expediente_rubrica;

    @Getter
    @Setter
    @Column(name="anio_expediente_rubrica")
    private String anio_expediente_rubrica;

    @Getter
    @Setter
    @Column(name="otros_instrumentos",columnDefinition = "TEXT")
    private String otros_instrumentos;

    @Getter
    @Setter
    @Column(name="dia_cierre_ejercicio")
    private String dia_cierre_ejercicio;

    @Getter
    @Setter
    @Column(name="mes_cierre_ejercicio")
    private String mes_cierre_ejercicio;

    @Getter
    @Setter
    @Column(name="beneficiarios",columnDefinition = "TEXT")
    private String beneficiarios;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sociedad")
    private Set<Socio> listaSocios = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sociedad")
    private Set<Rubrica> listaRubricas = new HashSet<>();

    @JsonManagedReference
    public Set<Socio> getListaSocios() {
        return listaSocios;
    }

    @JsonManagedReference
    public Set<Rubrica> getListaRubricas() {
        return listaRubricas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sociedad")
    private Set<PersonaJuridica> listaPersonasJuridicas = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sociedad")
    private Set<SedeSocial> listaSedesSociales = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sociedad")
    private Set<Expediente> listaExpedientes = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_sociedad")
    private TipoSociedad tipoSociedad;

    @JsonManagedReference
    public Set<PersonaJuridica> getListaPersonasJuridicas() {
        return listaPersonasJuridicas;
    }

    @JsonManagedReference
    public Set<SedeSocial> getListaSedesSociales() {
        return listaSedesSociales;
    }

    @JsonManagedReference
    public Set<Expediente> getListaExpedientes() {
        return listaExpedientes;
    }

    public TipoSociedad getTipoSociedad(){
        return tipoSociedad;
    }









}
