//package com.antonio.comunidad.config;
//
//import com.antonio.comunidad.security.JwtAuthEntryPoint;
//import com.antonio.comunidad.security.JwtAuthenticationFilter;
//import com.antonio.comunidad.service.UsuarioServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UsuarioServiceImpl userDetailsService;
//    private final JwtAuthEntryPoint unauthorizedHandler;
//    private final JwtAuthenticationFilter jwtAuthTokenFilter;
//
//    public SecurityConfig(UsuarioServiceImpl userDetailsService, JwtAuthEntryPoint unauthorizedHandler, JwtAuthenticationFilter jwtAuthTokenFilter) {
//        this.userDetailsService = userDetailsService;
//        this.unauthorizedHandler = unauthorizedHandler;
//        this.jwtAuthTokenFilter = jwtAuthTokenFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para APIs RESTful
//                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(unauthorizedHandler))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless, sin sesiones
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/**").permitAll() // Permitir accesos públicos a /api/auth/**
//                        .anyRequest().authenticated()) // Cualquier otra solicitud requiere autenticación
//                .addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class); // Añadir el filtro JWT antes del UsernamePasswordAuthenticationFilter
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Para codificar las contraseñas
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService((UserDetailsService) userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//}
