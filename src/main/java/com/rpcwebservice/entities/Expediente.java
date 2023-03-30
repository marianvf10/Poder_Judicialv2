package com.rpcwebservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="expedientes")
public class Expediente {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "numero")
    private String numero;

    @Getter
    @Setter
    @Column(name = "folio")
    private String folio;

    @Getter
    @Setter
    @Column(name = "organismo")
    private String organismo;

    @Getter
    @Setter
    @Column(name = "anio")
    private String anio;

    @Getter
    @Setter
    @Column(name = "tipo")
    private String tipo;

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

    @Getter
    @Setter
    @Column(name = "id_sociedad")
    private Integer id_sociedad;

    @Getter
    @Setter
    @Column(name = "id_categoria_expediente")
    private Integer id_categoria_expediente;

    @Getter
    @Setter
    @Column(name = "id_persona")
    private Integer id_persona;
}
