package com.antonio.comunidad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    private double cantidad;
    private String descripcion;
    private LocalDateTime fecha;
    private TipoMovimiento tipoMovimiento;

    public enum TipoMovimiento {
        INGRESO, GASTO
    }
}
