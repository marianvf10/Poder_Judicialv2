package com.rpcwebservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

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
    @Column(name="nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name="apellido")
    private String apellido;

    @Getter
    @Setter
    @Column(name="tipo_documento")
    private String tipo_documento;

    @Getter
    @Setter
    @Column(name="numero_documento")
    private String numero_documento;

    @Getter
    @Setter
    @Column(name="profesion")
    private String profesion;

    @Getter
    @Setter
    @Column(name="fecha_nacimiento")
    private Date fecha_nacimiento;

    @Getter
    @Setter
    @Column(name="nacionalidad")
    private String nacionalidad;

    @Getter
    @Setter
    @Column(name = "medida_cautelar", columnDefinition = "BOOLEAN")
    private Boolean medida_cautelar;

    @Getter
    @Setter
    @Column(name="telefono")
    private String telefono;

    @Getter
    @Setter
    @Column(name="sexo")
    private String sexo;
    @Getter
    @Setter
    @Column(name="cuil")
    private String cuil;

    @Getter
    @Setter
    @Column(name = "valid", columnDefinition = "BOOLEAN")
    private Boolean valid;

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
    @CreationTimestamp
    @Column(name = "deleted_at")
    private Date deleted_at;

    @Getter
    @Setter
    @Column(name="create_user")
    private String create_user;
    @Getter
    @Setter
    @Column(name="update_user")
    private String update_user;
    @Getter
    @Setter
    @Column(name="delete_user")
    private String delete_user;

}
