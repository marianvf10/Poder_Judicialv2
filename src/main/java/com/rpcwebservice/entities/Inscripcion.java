package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="inscripciones")
public class Inscripcion {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "numero")
    private Integer numero;

    @Getter
    @Setter
    @Column(name = "fecha")
    private Date fecha;

    @Getter
    @Setter
    @Column(name = "folio_desde")
    private Integer folioDesde;

    @Getter
    @Setter
    @Column(name = "folio_hasta")
    private Integer folioHasta;

    @Getter
    @Setter
    @Column(name = "tomo_numero")
    private String tomoNumero;

    @Getter
    @Setter
    @Column(name = "tomo_anio")
    private String tomoAnio;

    @Getter
    @Setter
    @Column(name = "inicial", columnDefinition = "BOOLEAN")
    private boolean inicial;

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
    @Column(name = "id_tipo_tomo")
    private Integer id_tipo_tomo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inscripcion")
    private Set<Antecedente> listaAntecedentes = new HashSet<>();
    @JsonManagedReference
    public Set<Antecedente> getListaAntecedentes() {
        return listaAntecedentes;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inscripcion")
    private Set<SedeSocial> listaSedesSociales = new HashSet<>();
    @JsonManagedReference
    public Set<SedeSocial> getListaSedesSociales() {
        return listaSedesSociales;
    }
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_expediente")
    private Expediente expediente;
    @JsonBackReference
    public Expediente getExpediente(){
        return expediente;
    }


}
