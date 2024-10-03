package com.antonio.comunidad.service;

import com.antonio.comunidad.dto.ReservaDTO;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<ReservaDTO> getAllReservas();
    Optional<ReservaDTO> getReservaById(Long id);
    ReservaDTO createReserva(ReservaDTO reserva);
    ReservaDTO updateReserva(Long id, ReservaDTO reserva);
    void deleteReserva(Long id);
}
