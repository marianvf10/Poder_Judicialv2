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
    private Integer folio_desde;

    @Getter
    @Setter
    @Column(name = "folio_hasta")
    private Integer folio_hasta;

    @Getter
    @Setter
    @Column(name = "tomo_numero")
    private String tomo_numero;

    @Getter
    @Setter
    @Column(name = "tomo_anio")
    private String tomo_anio;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inscripcion")
    private Set<SedeSocial> listaSedesSociales = new HashSet<>();

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_expediente")
    private Expediente expediente;
    @JsonManagedReference
    public Set<Antecedente> getListaAntecedentes() {
        return listaAntecedentes;
    }

    @JsonManagedReference
    public Set<SedeSocial> getListaSedesSociales() {
        return listaSedesSociales;
    }

    @JsonBackReference
    public Expediente getExpediente(){
        return expediente;
    }


}
