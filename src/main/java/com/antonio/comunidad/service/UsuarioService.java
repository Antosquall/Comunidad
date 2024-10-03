package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioDTO> getAllUsuarios();
    Optional<UsuarioDTO> getUsuarioById(Long id);
    UsuarioDTO createUsuario(UsuarioDTO usuario);
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuario);
    void deleteUsuario(Long id);
}
