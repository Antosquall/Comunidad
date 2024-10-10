package com.antonio.comunidad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vivienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloque;
    private String piso;
    private String puerta;
    private Boolean alquilado;

    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;

    @OneToMany(mappedBy = "vivienda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuarios;
}
