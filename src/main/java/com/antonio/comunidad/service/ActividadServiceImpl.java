package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.ActividadDTO;
import com.antonio.comunidad.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.antonio.comunidad.entity.Actividad;


@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public List<ActividadDTO> getAllActividades() {
        List<Actividad> actividades = actividadRepository.findAll();
        return actividades.stream()
                .map(actividad -> mapToDTO(actividad))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ActividadDTO> getActividadById(Long id) {
        return Optional.empty();
    }

    @Override
    public ActividadDTO createActividad(ActividadDTO actividad) {
        return null;
    }

    @Override
    public ActividadDTO updateActividad(Long id, ActividadDTO actividad) {
        return null;
    }

    @Override
    public void deleteActividad(Long id) {

    }

    private ActividadDTO mapToDTO(Actividad actividad) {
        // Lógica para convertir entidad a DTO
        ActividadDTO actividadDTO = new ActividadDTO();
        // Mapear atributos
        return actividadDTO;
    }

    private Actividad mapToEntity(ActividadDTO actividadDTO) {
        // Lógica para convertir DTO a entidad
        Actividad actividad = new Actividad();
        // Mapear atributos
        return actividad;
    }
}