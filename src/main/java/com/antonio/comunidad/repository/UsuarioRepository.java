package com.antonio.comunidad.repository;

import com.antonio.comunidad.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Long> {
    // Puedes añadir consultas personalizadas aquí si es necesario
}
