package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.LoginRequestDTO;
import com.antonio.comunidad.dto.RegisterRequestDTO;
import com.antonio.comunidad.repository.UsuarioRepository;
import com.antonio.comunidad.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String authenticateUser(LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(String.valueOf(authentication));
    }

    public void registerUser(RegisterRequestDTO registerRequest) {
        // Lógica para registrar un nuevo usuario en la base de datos
    }
}
