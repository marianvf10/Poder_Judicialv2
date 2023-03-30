package com.rpcwebservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "sede_social")
public class SedeSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name="calle")
    private String calle;

    @Getter
    @Setter
    @Column(name="numero")
    private String numero;

    @Getter
    @Setter
    @Column(name="otros")
    private String otros;

    @Getter
    @Setter
    @Column(name = "validado", columnDefinition = "BOOLEAN")
    private boolean validado;

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
    @Column(name = "id_sociedad")
    private Integer id_sociedad;

    @Getter
    @Setter
    @Column(name = "id_inscripcion")
    private Integer id_inscripcion;


    public SedeSocial() {
    }
}
