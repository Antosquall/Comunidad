package com.antonio.comunidad.repository;

import com.antonio.comunidad.dto.ActividadDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<ActividadDTO, Long> {
    // Añadir consultas personalizadas si es necesario
}
