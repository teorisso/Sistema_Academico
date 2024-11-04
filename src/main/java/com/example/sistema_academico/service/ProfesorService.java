package com.example.sistema_academico.service;

import com.example.sistema_academico.entity.Profesor;
import com.example.sistema_academico.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public void addProfesor(Profesor profesor) {
        try {
            profesorRepository.save(profesor);
            System.out.println("Profesor agregado con éxito");
            System.out.println(profesor);
        } catch (Exception e) {
            System.out.println("Error al agregar profesor");
            System.out.println(e);
        }
    }

    public void deleteProfesor(Integer id) {
        try {
            profesorRepository.deleteById(id);
            System.out.println("Profesor eliminado con éxito");
        } catch (Exception e) {
            System.out.println("Error al eliminar profesor");
            System.out.println(e);
        }
    }

    public Profesor getProfesor(Integer id) {
        try {
            Profesor profesor = profesorRepository.findById(id).orElse(null);
            System.out.println("Profesor obtenido con éxito");
            System.out.println(profesor);
            return profesor;
        } catch (Exception e) {
            System.out.println("Error al obtener profesor");
            System.out.println(e);
            return null;
        }
    }

    public List<Profesor> getProfesores() {
        try {
            List<Profesor> profesores = profesorRepository.findAll();
            System.out.println("Profesores obtenidos con éxito");
            System.out.println(profesores);
            return profesores;
        } catch (Exception e) {
            System.out.println("Error al obtener profesores");
            System.out.println(e);
            return null;
        }
    }

    public void updateProfesor(Profesor profesor) {
        try {
            profesorRepository.save(profesor);
            System.out.println("Profesor actualizado con éxito");
            System.out.println(profesor);
        } catch (Exception e) {
            System.out.println("Error al actualizar profesor");
            System.out.println(e);
        }
    }
}
