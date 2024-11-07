package com.example.sistema_academico.controller;

import com.example.sistema_academico.entity.Alumno;
import com.example.sistema_academico.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/add")
    public void addAlumno(@RequestBody Alumno alumno) {
        alumnoService.addAlumno(alumno, alumno.getComision().getId());

    }

    @PostMapping("/crear")
    public String crearAlumno(@RequestBody Alumno alumno) {
        alumnoService.crearAlumno(alumno);
        return "Alumno creado con exito";
    }


    @DeleteMapping("/delete/{legajo}")
    public void deleteAlumno(@PathVariable Integer legajo) {
        alumnoService.deleteAlumno(legajo);
    }

    @DeleteMapping("/borrar/{legajo}")
    public String borrarAlumno(@PathVariable Integer legajo) {
        alumnoService.borrarAlumno(legajo);
        return "Alumno borrado con éxito";
    }

    @GetMapping("/get")
    public List<Alumno> getAlumnos() {
        return alumnoService.getAlumnos();
    }

    @GetMapping("/traer")
    public List<Alumno> traerAlumnos() {
        return alumnoService.traerAlumnos();
    }

    @GetMapping("/get/{legajo}")
    public Alumno getAlumno(@PathVariable Integer legajo) {
        return alumnoService.getAlumno(legajo);
    }

    @GetMapping("/traer/{legajo}")
    public Alumno traerAlumno(@PathVariable Integer legajo) {
        return alumnoService.traerAlumno(legajo);
    }

    @PutMapping("/update")
    public void updateAlumno(@RequestBody Alumno alumno) {
        alumnoService.updateAlumno(alumno);
    }

    @PutMapping("/editar/{legajo}")
    public Alumno editarAlumno(@PathVariable Integer legajo,
                               @RequestParam(required = false, name = "nombre") String nombre,
                               @RequestParam(required = false, name = "apellido") String apellido) {

        alumnoService.editarAlumno(legajo, nombre, apellido);
        return alumnoService.getAlumno(legajo);

    }
}