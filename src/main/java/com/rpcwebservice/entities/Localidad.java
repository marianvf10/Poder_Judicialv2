package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="localidades")
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "codigo_postal")
    private String codigo_postal;
    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;


    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;
    @JsonBackReference
    public Provincia getProvincia() {
        return provincia;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "localidad")
    private Set<SedeSocial> listaSedesSociales = new HashSet<>();
    @JsonManagedReference
    public Set<SedeSocial> getSedesSociales(){
        return listaSedesSociales;
    }


}
