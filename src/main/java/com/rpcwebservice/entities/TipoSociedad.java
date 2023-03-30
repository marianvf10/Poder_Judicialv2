package com.rpcwebservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sede_social")
public class TipoSociedad {
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
    @Column(name="siglas")
    private String siglas;
    @Getter
    @Setter
    @Column(name="tipo")
    private String tipo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoSociedad")
    private Set<PersonaJuridica> listaPersonasJuridicas = new HashSet<>();

    public Set<PersonaJuridica> getListaPersonasJuridicas() {
        return listaPersonasJuridicas;
    }
}
