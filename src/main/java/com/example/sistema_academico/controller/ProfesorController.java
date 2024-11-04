package com.example.sistema_academico.controller;

import com.example.sistema_academico.entity.Profesor;
import com.example.sistema_academico.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/add")
    public void addProfesor(@RequestBody Profesor profesor) {
        profesorService.addProfesor(profesor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfesor(@PathVariable Integer id) {
        profesorService.deleteProfesor(id);
    }

    @GetMapping("/get")
    public List<Profesor> getProfesores() {
        return profesorService.getProfesores();
    }

    @GetMapping("/get/{id}")
    public Profesor getProfesor(@PathVariable Integer id) {
        return profesorService.getProfesor(id);
    }

    @PutMapping("/update")
    public void updateProfesor(@RequestBody Profesor profesor) {
        profesorService.updateProfesor(profesor);
    }
}
