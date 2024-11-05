package com.example.sistema_academico.service;

import com.example.sistema_academico.entity.Calificacion;
import com.example.sistema_academico.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    // Agregar una nueva calificación para un alumno
    public void addCalificacion(Integer legajo, Calificacion calificacion) {
        try {
            calificacion.calcularCalificacion();
            calificacionRepository.save(calificacion);
            System.out.println("Calificación agregada con éxito:\n" + calificacion);
        } catch (Exception e) {
            System.out.println("Error al agregar calificación:\n" + e);
        }
    }

    // Eliminar todas las calificaciones de un alumno por su legajo
    public void deleteCalificacionesPorLegajo(Integer legajo) {
        try {
            List<Calificacion> calificaciones = calificacionRepository.findByAlumnoLegajo(legajo);
            if (!calificaciones.isEmpty()) {
                calificacionRepository.deleteAll(calificaciones);
                System.out.println("Calificaciones eliminadas con éxito para el alumno con legajo: " + legajo);
            } else {
                System.out.println("No se encontraron calificaciones para el alumno con legajo: " + legajo);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar calificaciones:\n" + e);
        }
    }

    // Obtener todas las calificaciones de un alumno por su legajo
    public List<Calificacion> getCalificaciones(Integer legajoAlumno) {
        try {
            List<Calificacion> calificaciones = calificacionRepository.findByAlumnoLegajo(legajoAlumno);
            if (calificaciones.isEmpty()) {
                System.out.println("No se encontraron calificaciones para el alumno con legajo: " + legajoAlumno);
            } else {
                System.out.println("Calificaciones obtenidas con éxito para el alumno con legajo: " + legajoAlumno);
            }
            return calificaciones;
        } catch (Exception e) {
            System.out.println("Error al obtener calificaciones:\n" + e);
            return null;
        }
    }

    // Obtener todas las calificaciones existentes
    public List<Calificacion> getCalificaciones() {
        try {
            List<Calificacion> calificaciones = calificacionRepository.findAll();
            if (calificaciones.isEmpty()) {
                System.out.println("No se encontraron calificaciones.");
            } else {
                System.out.println("Calificaciones obtenidas con éxito.");
            }
            return calificaciones;
        } catch (Exception e) {
            System.out.println("Error al obtener calificaciones:\n" + e);
            return null;
        }
    }

    // Actualizar las calificaciones de un alumno específico
    public void updateCalificacion(Integer legajo, Calificacion nuevaCalificacion) {
        try {
            List<Calificacion> calificaciones = calificacionRepository.findByAlumnoLegajo(legajo);
            if (!calificaciones.isEmpty()) {
                for (Calificacion calificacion : calificaciones) {
                    calificacion.setNota1(nuevaCalificacion.getNota1());
                    calificacion.setNota2(nuevaCalificacion.getNota2());
                    calificacion.setNota3(nuevaCalificacion.getNota3());

                    calificacion.calcularCalificacion();

                    calificacionRepository.save(calificacion);
                }
                System.out.println("Calificaciones actualizadas con éxito para el alumno con legajo: " + legajo);
            } else {
                System.out.println("No se encontraron calificaciones para el alumno con legajo: " + legajo);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar calificaciones:\n" + e);
        }
    }
}
