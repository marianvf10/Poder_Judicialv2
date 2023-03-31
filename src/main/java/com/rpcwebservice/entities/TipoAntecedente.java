package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tipos_antecedentes")
public class TipoAntecedente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name="nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name="tramite")
    private String tramite;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoAntecedente")
    private Set<Antecedente> listaAntecedentes = new HashSet<>();

    @JsonManagedReference
    public Set<Antecedente> getListaAntecedentes() {
        return listaAntecedentes;
    }

}
