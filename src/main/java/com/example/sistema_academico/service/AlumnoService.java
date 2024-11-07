package com.example.sistema_academico.service;

import com.example.sistema_academico.entity.Alumno;
import com.example.sistema_academico.entity.Materia;
import com.example.sistema_academico.repository.AlumnoRepository;
import com.example.sistema_academico.repository.ComisionRepository;
import com.example.sistema_academico.repository.MateriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private ComisionRepository comisionRepository;
    @Autowired
    private MateriaRepository materiaRepository;

    @Transactional
    public void addAlumno(Alumno alumno, Integer comisionId) {
        try {
            alumno.setComision(comisionRepository.findById(comisionId).orElse(null));
            alumno.setMaterias(new ArrayList<Materia>());
            alumnoRepository.save(alumno);
            System.out.println("Alumno agregado con exito\n" + alumno);
        } catch (Exception e) {
            System.out.println("Error al agregar alumno\n" + e);
        }
    }

    @Transactional
    public void addMateria(Integer legajo, Integer materiaId) {
        try {
            Alumno alumno = alumnoRepository.findById(legajo).orElse(null);
            Materia materia = materiaRepository.findById(materiaId).orElse(null);
            if (alumno != null && materia != null) {
                alumno.getMaterias().add(materia);
                alumnoRepository.save(alumno);
                System.out.println("Materia agregada con exito\n" + materia);
            }
        } catch (Exception e) {
            System.out.println("Error al agregar materia\n" + e);
        }
    }

    @Transactional
    public void crearAlumno(Alumno alumno) {
        try {
            List<Materia> materias = new ArrayList<>();


            alumno.setMaterias(new ArrayList<Materia>());
            alumnoRepository.save(alumno);
        } catch (Exception e) {
            System.out.println("Error al crear alumno\n" + e);
        }
    }


    @Transactional
    public void deleteAlumno(Integer legajo) {
        try {
            alumnoRepository.deleteById(legajo);
            System.out.println("Alumno eliminado con exito");
        } catch (Exception e) {
            System.out.println("Error al eliminar alumno\n" + e);
        }
    }

    public void borrarAlumno(Integer legajo) {
        try {
            alumnoRepository.deleteById(legajo);
            System.out.println("Alumno eliminado con exito");
        } catch (Exception e) {
            System.out.println("Error al eliminar alumno\n" + e);
        }
    }

    public Alumno getAlumno(Integer legajo) {
        try {
            Alumno alumno = alumnoRepository.findById(legajo).orElse(null);
            System.out.println("Alumno obtenido con exito\n" + alumno.toString());
            return alumno;
        } catch (Exception e) {
            System.out.println("Error al obtener alumno\n" + e);
            return null;
        }
    }

    public Alumno traerAlumno(Integer legajo) {
        try {
            Alumno alumno = alumnoRepository.findById(legajo).orElse(null);
            return alumno;
        } catch (Exception e) {
            System.out.println("Error al obtener alumno\n" + e);
            return null;
        }
    }

    public List<Alumno> traerAlumnos() {
        try {
            List<Alumno> alumnos = alumnoRepository.findAll();
            return alumnos;
        } catch (Exception e) {
            System.out.println("Error al obtener alumnos\n" + e);
            return null;
        }
    }

    public List<Alumno> getAlumnos() {
        try {
            List<Alumno> alumnos = alumnoRepository.findAll();
            System.out.println("Alumnos obtenidos con exito\n" + alumnos);
            return alumnos;
        } catch (Exception e) {
            System.out.println("Error al obtener alumnos\n" + e);
            return null;
        }
    }

    @Transactional
    public void updateAlumno(Alumno alumno) {
        try {
            alumnoRepository.save(alumno);
            System.out.println("Alumno actualizado con exito\n" + alumno);
        } catch (Exception e) {
            System.out.println("Error al actualizar alumno\n" + e);
        }
    }

    public void editarAlumno(Integer legajo, String nombre, String apellido) {
        try {
            Alumno alu = this.traerAlumno(legajo);
            if (nombre != null) {
                alu.setNombre(nombre);
            }
            if (apellido != null) {
                alu.setApellido(apellido);
            }
            this.crearAlumno(alu);
        } catch (Exception e) {
            System.out.println("Error al actualizar alumno\n" + e);
        }
    }
}