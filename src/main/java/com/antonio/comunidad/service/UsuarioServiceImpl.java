package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.UsuarioDTO;
import com.antonio.comunidad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioDTO> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }


    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuario) {
        Optional<UsuarioDTO> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()) {
            usuario.setId(id); // asegurarse de que el id esté configurado
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
