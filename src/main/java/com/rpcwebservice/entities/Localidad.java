package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_provincia", nullable = false)
    private Provincia provincia;

    public Localidad() {
    }
    @JsonBackReference
    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia){
        this.provincia = provincia;
    }


}
