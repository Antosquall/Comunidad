package com.antonio.comunidad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private boolean esPrivado;

    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;

    @OneToMany(mappedBy = "foro", cascade = CascadeType.ALL)
    private List<Mensaje> mensajes;

    @OneToMany(mappedBy = "foro", cascade = CascadeType.ALL)
    private List<PermisoForo> permisos;
}
