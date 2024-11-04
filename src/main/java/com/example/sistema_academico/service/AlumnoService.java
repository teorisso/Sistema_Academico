package com.example.sistema_academico.service;

import com.example.sistema_academico.entity.Alumno;
import com.example.sistema_academico.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    public void addAlumno(Alumno alumno) {
        try {
            alumnoRepository.save(alumno);
            System.out.println("Alumno agregado con exito");
            System.out.println(alumno);
        } catch (Exception e) {
            System.out.println("Error al agregar alumno");
            System.out.println(e);
        }
    }

public void deleteAlumno(Integer legajo) {
    try {
        alumnoRepository.deleteById(legajo);
        System.out.println("Alumno eliminado con exito");
    } catch (Exception e) {
        System.out.println("Error al eliminar alumno");
        System.out.println(e);
    }
}

public Alumno getAlumno(Integer legajo) {
    try {
        Alumno alumno = alumnoRepository.findById(legajo).orElse(null);
        System.out.println("Alumno obtenido con exito");
        System.out.println(alumno);
        return alumno;
    } catch (Exception e) {
        System.out.println("Error al obtener alumno");
        System.out.println(e);
        return null;
    }
}

public List<Alumno> getAlumnos() {
    try {
        List<Alumno> alumnos = alumnoRepository.findAll();
        System.out.println("Alumnos obtenidos con exito");
        System.out.println(alumnos);
        return alumnos;
    } catch (Exception e) {
        System.out.println("Error al obtener alumnos");
        System.out.println(e);
        return null;
    }
}

public void updateAlumno(Alumno alumno) {
    try {
        alumnoRepository.save(alumno);
        System.out.println("Alumno actualizado con exito");
        System.out.println(alumno);
    } catch (Exception e) {
        System.out.println("Error al actualizar alumno");
        System.out.println(e);
    }
}

}
