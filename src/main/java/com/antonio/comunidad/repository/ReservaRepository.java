package com.antonio.comunidad.repository;

import com.antonio.comunidad.dto.ReservaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaDTO, Long> {
    // Consultas adicionales si necesitas búsquedas específicas
}
