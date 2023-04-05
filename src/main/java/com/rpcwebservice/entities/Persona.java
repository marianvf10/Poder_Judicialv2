package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name = "apellido")
    private String apellido;

    @Getter
    @Setter
    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Getter
    @Setter
    @Column(name = "numero_documento")
    private String numero_documento;

    @Getter
    @Setter
    @Column(name = "profesion")
    private String profesion;

    @Getter
    @Setter
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Getter
    @Setter
    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Getter
    @Setter
    @Column(name = "medida_cautelar", columnDefinition = "BOOLEAN")
    private Boolean medida_cautelar;

    @Setter
    @Column(name = "telefono")
    private String telefono;

    @Getter
    @Setter
    @Column(name = "sexo")
    private String sexo;
    @Getter
    @Setter
    @Column(name = "cuil")
    private String cuil;

    @Getter
    @Setter
    @Column(name = "valid", columnDefinition = "BOOLEAN")
    private Boolean valid;

    @Setter
    @CreationTimestamp
    @Getter
    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "deleted_at")
    private Date deleted_at;

    /*
    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "updated_at")
    private Date updated_at;
    */



    @Getter
    @Setter
    @Column(name="update_user")
    private String update_user;


    @Getter
    @Setter
    @Column(name = "create_user")
    private String create_user;

    @Getter
    @Setter
    @Column(name = "delete_user")
    private String delete_user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
    private Set<Socio> listaSocios = new HashSet<>();
    @JsonManagedReference
    public Set<Socio> getListaSocios() {
        return listaSocios;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
    private Set<Expediente> expedientes = new HashSet<>();
    @JsonManagedReference
    public Set<Expediente> getExpedientes() {
        return expedientes;
    }
}
