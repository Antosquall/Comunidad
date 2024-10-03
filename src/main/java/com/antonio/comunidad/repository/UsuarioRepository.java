package com.antonio.comunidad.repository;

import com.antonio.comunidad.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Este método será generado automáticamente por Spring Data JPA
    Optional<Usuario> findByUsername(String username);
}
