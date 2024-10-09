package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.ReservaDTO;
import com.antonio.comunidad.entity.Actividad;
import com.antonio.comunidad.entity.Reserva;
import com.antonio.comunidad.entity.Usuario;
import com.antonio.comunidad.repository.ActividadRepository;
import com.antonio.comunidad.repository.ReservaRepository;
import com.antonio.comunidad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<ReservaDTO> getAllReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservas.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReservaDTO> getReservaById(Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return Optional.ofNullable(reserva.map(this::mapToDTO).orElse(null));
    }

    @Override
    public ReservaDTO createReserva(ReservaDTO reservaDTO) {
        Reserva reserva = mapToEntity(reservaDTO);
        Reserva newReserva = reservaRepository.save(reserva);
        return mapToDTO(newReserva);
    }

    @Override
    public ReservaDTO updateReserva(Long id, ReservaDTO reservaDTO) {
        Optional<Reserva> existingReserva = reservaRepository.findById(id);
        if (existingReserva.isPresent()) {
            Reserva reserva = mapToEntity(reservaDTO);
            reserva.setId(id); // Asegúrate de que el id esté configurado
            Reserva updatedReserva = reservaRepository.save(reserva);
            return mapToDTO(updatedReserva);
        }
        return null;
    }

    @Override
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    // Método para convertir una entidad Reserva a DTO
    private ReservaDTO mapToDTO(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setActividadId(reserva.getActividad().getId());
        reservaDTO.setUsuarioId(reserva.getUsuario().getId());
        reservaDTO.setFechaReserva(reserva.getFechaReserva());
        return reservaDTO;
    }

    // Método para convertir un DTO en una entidad Reserva
    private Reserva mapToEntity(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        Optional<Actividad> actividad = actividadRepository.findById(reservaDTO.getActividadId());
        Optional<Usuario> usuario = usuarioRepository.findById(reservaDTO.getUsuarioId());

        if (actividad.isPresent() && usuario.isPresent()) {
            reserva.setActividad(actividad.get());
            reserva.setUsuario(usuario.get());
            reserva.setFechaReserva(reservaDTO.getFechaReserva());
        }
        return reserva;
    }
}
