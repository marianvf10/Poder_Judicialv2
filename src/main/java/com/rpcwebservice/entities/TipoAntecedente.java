package com.rpcwebservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

}
