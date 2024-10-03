package com.antonio.comunidad.controller;

import com.antonio.comunidad.dto.ActividadDTO;
import com.antonio.comunidad.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public List<ActividadDTO> getAllActividades() {
        return actividadService.getAllActividades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> getActividadById(@PathVariable Long id) {
        Optional<ActividadDTO> actividad = actividadService.getActividadById(id);
        return actividad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ActividadDTO> createActividad(@RequestBody ActividadDTO actividad) {
        ActividadDTO createdActividad = actividadService.createActividad(actividad);
        return ResponseEntity.ok(createdActividad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadDTO> updateActividad(@PathVariable Long id, @RequestBody ActividadDTO actividad) {
        ActividadDTO updatedActividad = actividadService.updateActividad(id, actividad);
        if (updatedActividad != null) {
            return ResponseEntity.ok(updatedActividad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActividad(@PathVariable Long id) {
        actividadService.deleteActividad(id);
        return ResponseEntity.noContent().build();
    }
}
