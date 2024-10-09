package com.antonio.comunidad.repository;

import com.antonio.comunidad.dto.ReservaDTO;
import com.antonio.comunidad.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Consultas adicionales si necesitas búsquedas específicas
}
