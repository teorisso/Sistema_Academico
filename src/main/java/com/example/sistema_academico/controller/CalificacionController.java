package com.example.sistema_academico.controller;

import com.example.sistema_academico.entity.Calificacion;
import com.example.sistema_academico.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    // Agregar una nueva calificación para un alumno específico
    @PostMapping("/add/{legajo}")
    public void addCalificacion(@PathVariable Integer legajo, @RequestBody Calificacion calificacion) {
        calificacionService.addCalificacion(legajo, calificacion);
    }

    // Eliminar todas las calificaciones de un alumno por su legajo
    @DeleteMapping("/deleteByLegajo/{legajo}")
    public void deleteCalificacionesPorLegajo(@PathVariable Integer legajo) {
        calificacionService.deleteCalificacionesPorLegajo(legajo);
    }

    // Obtener todas las calificaciones de un alumno por su legajo
    @GetMapping("/getByLegajo/{legajo}")
    public List<Calificacion> getCalificacionesByLegajo(@PathVariable Integer legajo) {
        return calificacionService.getCalificaciones(legajo);
    }

    // Obtener todas las calificaciones existentes
    @GetMapping("/getAll")
    public List<Calificacion> getAllCalificaciones() {
        return calificacionService.getCalificaciones();
    }

    // Actualizar las calificaciones de un alumno específico
    @PutMapping("/update/{legajo}")
    public void updateCalificacion(@PathVariable Integer legajo, @RequestBody Calificacion nuevaCalificacion) {
        calificacionService.updateCalificacion(legajo, nuevaCalificacion);
    }
}
