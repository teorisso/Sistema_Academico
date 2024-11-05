package com.example.sistema_academico.service;

import com.example.sistema_academico.entity.Profesor;
import com.example.sistema_academico.repository.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Transactional
    public void addProfesor(Profesor profesor) {
        try {
            profesorRepository.save(profesor);
            System.out.println("Profesor agregado con éxito\n" + profesor);
        } catch (Exception e) {
            System.out.println("Error al agregar profesor\n" + e);
        }
    }

    public void deleteProfesor(Integer id) {
        try {
            profesorRepository.deleteById(id);
            System.out.println("Profesor eliminado con éxito");
        } catch (Exception e) {
            System.out.println("Error al eliminar profesor\n" + e);
        }
    }

    public Profesor getProfesor(Integer id) {
        try {
            Profesor profesor = profesorRepository.findById(id).orElse(null);
            System.out.println("Profesor obtenido con éxito\n" + profesor);
            return profesor;
        } catch (Exception e) {
            System.out.println("Error al obtener profesor\n" + e);
            return null;
        }
    }

    public List<Profesor> getProfesores() {
        try {
            List<Profesor> profesores = profesorRepository.findAll();
            System.out.println("Profesores obtenidos con éxito\n" + profesores);
            return profesores;
        } catch (Exception e) {
            System.out.println("Error al obtener profesores\n" + e);
            return null;
        }
    }

    public void updateProfesor(Profesor profesor) {
        try {
            profesorRepository.save(profesor);
            System.out.println("Profesor actualizado con éxito\n" + profesor);
        } catch (Exception e) {
            System.out.println("Error al actualizar profesor\n" + e);
        }
    }
}
