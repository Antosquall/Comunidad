package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.ActividadDTO;

import java.util.List;
import java.util.Optional;

public interface ActividadService {
    List<ActividadDTO> getAllActividades();
    Optional<ActividadDTO> getActividadById(Long id);
    ActividadDTO createActividad(ActividadDTO actividad);
    ActividadDTO updateActividad(Long id, ActividadDTO actividad);
    void deleteActividad(Long id);
}
