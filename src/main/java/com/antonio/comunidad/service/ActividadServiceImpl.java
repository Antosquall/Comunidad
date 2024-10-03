package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.ActividadDTO;
import com.antonio.comunidad.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public List<ActividadDTO> getAllActividades() {
        return actividadRepository.findAll();
    }

    @Override
    public Optional<ActividadDTO> getActividadById(Long id) {
        return actividadRepository.findById(id);
    }

    @Override
    public ActividadDTO createActividad(ActividadDTO actividad) {
        return actividadRepository.save(actividad);
    }

    @Override
    public ActividadDTO updateActividad(Long id, ActividadDTO actividad) {
        Optional<ActividadDTO> existingActividad = actividadRepository.findById(id);
        if (existingActividad.isPresent()) {
            actividad.setId(id);
            return actividadRepository.save(actividad);
        }
        return null;
    }

    @Override
    public void deleteActividad(Long id) {
        actividadRepository.deleteById(id);
    }
}
