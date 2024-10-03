package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.ReservaDTO;
import com.antonio.comunidad.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<ReservaDTO> getAllReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<ReservaDTO> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public ReservaDTO createReserva(ReservaDTO reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public ReservaDTO updateReserva(Long id, ReservaDTO reserva) {
        Optional<ReservaDTO> existingReserva = reservaRepository.findById(id);
        if (existingReserva.isPresent()) {
            reserva.setId(id);
            return reservaRepository.save(reserva);
        }
        return null;
    }

    @Override
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
