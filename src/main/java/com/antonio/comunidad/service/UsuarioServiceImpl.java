package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.UsuarioDTO;
import com.antonio.comunidad.entity.Usuario;
import com.antonio.comunidad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        // Convertir la lista de entidades Usuario a DTO
        return usuarioRepository.findAll().stream()
                .map(UsuarioDTO::fromEntity) // Convierte cada Usuario a UsuarioDTO
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDTO> getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioDTO::fromEntity); // Convierte el Usuario a UsuarioDTO si está presente
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        // Convertir UsuarioDTO a Usuario (la lógica inversa puede ser necesaria aquí)
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setNombre(usuarioDTO.getNombreCompleto().split(" ")[0]); // Asumir que el primer nombre es el nombre
        usuario.setApellido(usuarioDTO.getNombreCompleto().split(" ")[1]); // Asumir que el segundo nombre es el apellido
        usuario.setEmail(usuarioDTO.getEmail());
        // Establecer otros campos
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return UsuarioDTO.fromEntity(savedUsuario);
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()) {
            Usuario usuario = existingUsuario.get();
            usuario.setUsername(usuarioDTO.getUsername());
            usuario.setEmail(usuarioDTO.getEmail());
            return convertToDTO(usuarioRepository.save(usuario));
        }
        return null;
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Conversión de Usuario a UsuarioDTO
    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setEmail(usuario.getEmail());
        return usuarioDTO;
    }

    // Conversión de UsuarioDTO a Usuario
    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setEmail(usuarioDTO.getEmail());
        return usuario;
    }
}
