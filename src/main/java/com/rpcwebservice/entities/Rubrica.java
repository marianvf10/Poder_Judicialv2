package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rpcwebservice.dtos.RubricasDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="rubricas")
@NamedNativeQuery(
        name = "buscarRubricaConSociedad",
        query =
                "SELECT DISTINCT r.id_sociedad,r.apertura as Fecha_Apertura, r.denominacion as Ru_Denominacion, r.numero_apertura, " +
                        "r.numero_clausura " +
                        "FROM " +
                        "sociedades s LEFT JOIN rubricas r ON s.id = r.id_sociedad " +
                        "WHERE r.id_sociedad = :idSociedad",
        resultSetMapping = "buscarRubricaConSociedad"
)
@SqlResultSetMapping(
        name = "buscarRubricaConSociedad",
        classes = @ConstructorResult(
                targetClass = RubricasDTO.class,
                columns = {
                        @ColumnResult(name = "id_sociedad", type = Integer.class),
                        @ColumnResult(name = "Fecha_Apertura", type = String.class),
                        @ColumnResult(name = "Ru_denominacion", type = String.class),
                        @ColumnResult(name = "numero_apertura", type = String.class),
                        @ColumnResult(name = "numero_clausura", type = String.class)
                }
        )
)
public class Rubrica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name="denominacion")
    private String denominacion;

    @Getter
    @Setter
    @Column(name="observaciones_apertura")
    private String observaciones_apertura;

    @Getter
    @Setter
    @Column(name="observaciones_clausura")
    private String observaciones_clausura;

    @Getter
    @Setter
    @Column(name="apertura")
    private Date apertura;

    @Getter
    @Setter
    @Column(name="clausura")
    private Date clausura;

    @Getter
    @Setter
    @Column(name="numero_apertura")
    private String numero_apertura;

    @Getter
    @Setter
    @Column(name="numero_clausura")
    private String numero_clausura;

    @Getter
    @Setter
    @Column(name="cantidad_folios")
    private Integer cantidad_folios;

    @Getter
    @Setter
    @Column(name="desde_folio")
    private Integer desde_folio;

    @Getter
    @Setter
    @Column(name="hasta_folio")
    private Integer hasta_folio;

    @Getter
    @Setter
    @Column(name="utilizado_hasta")
    private Integer utilizado_hasta;

    @Getter
    @Setter
    @Column(name = "hojas_blanco", columnDefinition = "BOOLEAN")
    private Boolean hojas_blanco;

    @Getter
    @Setter
    @Column(name="hojas_blanco_desde")
    private Integer hojas_blanco_desde;

    @Getter
    @Setter
    @Column(name="hojas_blanco_hasta")
    private Integer hojas_blanco_hasta;

    @Getter
    @Setter
    @Column(name = "hojas_anuladas", columnDefinition = "BOOLEAN")
    private Boolean hojas_anuladas;

    @Getter
    @Setter
    @Column(name="hojas_anuladas_desde")
    private Integer hojas_anuladas_desde;

    @Getter
    @Setter
    @Column(name="hojas_anuladas_hasta")
    private Integer hojas_anuladas_hasta;

    @Getter
    @Setter
    @Column(name="numero_rubrica_apertura")
    private String numero_rubrica_apertura;

    @Getter
    @Setter
    @Column(name="anio_rubrica_apertura")
    private String anio_rubrica_apertura;

    @Getter
    @Setter
    @Column(name="numero_rubrica_clausura")
    private String numero_rubrica_clausura;

    @Getter
    @Setter
    @Column(name = "extravio", columnDefinition = "BOOLEAN")
    private Boolean extravio;

    @Getter
    @Setter
    @Column(name = "robo", columnDefinition = "BOOLEAN")
    private Boolean robo;

    @Getter
    @Setter
    @Column(name = "destruccion", columnDefinition = "BOOLEAN")
    private Boolean destruccion;

    @Getter
    @Setter
    @Column(name="id_libro_comercio")
    private Integer id_libro_comercio;

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
    public Sociedad getSociedad(){
        return sociedad;
    }





}
