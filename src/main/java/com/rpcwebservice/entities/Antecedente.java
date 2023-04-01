package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="antecedentes")
public class Antecedente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Setter
    @Getter
    @Column(name="fecha")
    private String fecha;


    @Getter
    @Setter
    @Column(name = "protocolo_constancia")
    private Integer protocolo_constancia;

    @Getter
    @Setter
    @Column(name = "entrega_constancia")
    private Integer entrega_constancia;
    @Getter
    @Setter
    @Column(name = "legajo_constancia")
    private Integer legajo_constancia;

    @Getter
    @Setter
    @Column(name="usuario")
    private String usuario;

    @Getter
    @Setter
    @Column(name="fecha_baja")
    private Date fecha_baja;

    @Getter
    @Setter
    @Column(name="usuario_baja")
    private String usuario_baja;
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


    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sociedad")
    private Sociedad sociedad;
    @JsonBackReference
    public Sociedad getSociedad() {
        return sociedad;
    }


    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscripcion")
    private Inscripcion inscripcion;
    @JsonBackReference
    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_antecedente")
    private TipoAntecedente tipoAntecedente;
    @JsonBackReference
    public TipoAntecedente getTipoAntecedente() {
        return tipoAntecedente;
    }
}
