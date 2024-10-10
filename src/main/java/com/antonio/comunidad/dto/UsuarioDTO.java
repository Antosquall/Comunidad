package com.antonio.comunidad.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.antonio.comunidad.entity.Usuario;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String username;
    private String nombreCompleto;
    private String email;
    private String direccion;

    public static UsuarioDTO fromEntity(Usuario usuario) {
        String nombreCompleto = usuario.getNombre() + " " + usuario.getApellido();
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                nombreCompleto,
                usuario.getEmail(),
                usuario.getVivienda() != null ? usuario.getVivienda().getPiso() : null  // Si existe una vivienda asociada
        );
    }

}
