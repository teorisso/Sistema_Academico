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

    public void addCalificacion(Integer legajo, Calificacion calificacion) {
        try {
            List<Calificacion> calificacionesExistentes = calificacionRepository.findByAlumnoLegajo(legajo);
            calificacion.calcularCalificacion();
            calificacionRepository.save(calificacion);
            System.out.println("Calificación agregada con éxito\n" + calificacion);
        } catch (Exception e) {
            System.out.println("Error al agregar calificación\n" + e);
        }
    }

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
            System.out.println("Error al eliminar calificaciones\n" + e);
        }
    }

    public List<Calificacion> getCalificaciones(Integer legajoAlumno) {
        try {
            return calificacionRepository.findByAlumnoLegajo(legajoAlumno);
        } catch (Exception e) {
            System.out.println("Error al obtener calificaciones\n" + e);
            return null;
        }
    }

    public List<Calificacion> getCalificaciones() {
        try {
            return calificacionRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error al obtener calificaciones\n" + e);
            return null;
        }
    }

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
            System.out.println("Error al actualizar calificaciones\n" + e);
        }
    }



}
