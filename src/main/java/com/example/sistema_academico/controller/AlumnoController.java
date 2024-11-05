package com.example.sistema_academico.controller;

import com.example.sistema_academico.entity.Alumno;
import com.example.sistema_academico.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/add")
    public void addAlumno(@RequestBody Alumno alumno) {
        alumnoService.addAlumno(alumno);
    }

    @DeleteMapping("/delete/{legajo}")
    public void deleteAlumno(@PathVariable Integer legajo) {
        alumnoService.deleteAlumno(legajo);
    }

    @GetMapping("/get")
    public List<Alumno> getAlumnos() {
        return alumnoService.getAlumnos();
    }

    @GetMapping("/get/{legajo}")
    public Alumno getAlumno(@PathVariable Integer legajo) {
        return alumnoService.getAlumno(legajo);
    }

    @PutMapping("/update")
    public void updateAlumno(@RequestBody Alumno alumno) {
        alumnoService.updateAlumno(alumno);
    }
}