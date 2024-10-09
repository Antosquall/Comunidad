package com.antonio.comunidad.repository;

import com.antonio.comunidad.dto.ActividadDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.antonio.comunidad.entity.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    // Añadir consultas personalizadas si es necesario
}
