package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

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


    @Setter
    @Getter
    @Column(name="nombre")
    private String nombre;

    @Setter
    @Getter
    @Column(name="siglas")
    private String siglas;

    @Setter
    @Getter
    @Column(name="tipo")
    private String tipo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoSociedad")
    private Set<PersonaJuridica> listaPersonasJuridicas = new HashSet<>();

    @JsonManagedReference
    public Set<PersonaJuridica> getListaPersonasJuridicas() {
        return listaPersonasJuridicas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoSociedad")
    private Set<Sociedad> listaSociedades = new HashSet<>();
    @JsonManagedReference
    public Set<Sociedad> getListaSociedades() {
        return listaSociedades;
    }

}
