package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "provincias")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name="siglas")
    private String siglas;

    @Getter
    @Setter
    @Column(name="nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name="id_pais")
    private Integer id_pais;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provincia")
    private Set<Localidad> listaLocalidades = new HashSet<>();
    @JsonManagedReference
    public Set<Localidad> getListaLocalidades() {
        return listaLocalidades;
    }
}
