package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sociedad")
    private Sociedad sociedad;
    @JsonBackReference
    public Sociedad getSociedad(){
        return sociedad;
    }

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscripcion")
    private Inscripcion inscripcion;

    @JsonBackReference
    public Inscripcion getInscripcion(){
        return inscripcion;
    }


    public SedeSocial() {
    }
}
