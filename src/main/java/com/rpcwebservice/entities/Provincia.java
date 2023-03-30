package com.rpcwebservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public Provincia() {
    }
}
