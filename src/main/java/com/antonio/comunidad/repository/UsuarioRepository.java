package com.antonio.comunidad.repository;

import com.antonio.comunidad.entity.Usuario; // Asegúrate de que estás importando la entidad Usuario
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username); // Si trabajas con 'username' para autenticación
}
