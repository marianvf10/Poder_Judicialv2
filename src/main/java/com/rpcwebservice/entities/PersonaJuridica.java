package com.rpcwebservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="personas_juridicas")
public class PersonaJuridica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "denominacion", columnDefinition = "TEXT")
    private String denominacion;


    @Getter
    @Setter
    @Column(name = "id_tipo_sociedad")
    private Integer id_tipo_sociedad;


    @Getter
    @Setter
    @Column(name = "jurisdiccion")
    private String jurisdiccion;

    @Getter
    @Setter
    @Column(name = "numero")
    private Integer numero;

    @Getter
    @Setter
    @Column(name = "folio_desde")
    private Integer folio_desde;

    @Getter
    @Setter
    @Column(name = "folio_hasta")
    private Integer folio_hasta;

    @Getter
    @Setter
    @Column(name = "anio_inscripcion")
    private String anio_inscripcion;

    @Getter
    @Setter
    @Column(name = "tomo_numero")
    private String tomo_numero;

    @Getter
    @Setter
    @Column(name = "tomo_anio")
    private String tomo_anio;

    @Getter
    @Setter
    @Column(name = "cuit")
    private String cuit;

    @Getter
    @Setter
    @Column(name = "fecha")
    private Date fecha;

    @Getter
    @Setter
    @Column(name = "numero_decreto_formacion")
    private String numero_decreto_formacion;

    @Getter
    @Setter
    @Column(name = "representado_por")
    private String representado_por;

    @Getter
    @Setter
    @Column(name = "id_sociedad")
    private Integer id_sociedad;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personaJuridica")
    private Set<Socio> listaSocios = new HashSet<>();

    @JsonManagedReference
    public Set<Socio> getListaSocios() {
        return listaSocios;
    }
}
