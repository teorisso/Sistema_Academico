package com.example.sistema_academico.controller;

import com.example.sistema_academico.entity.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.sistema_academico.service.CalificacionService;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @PostMapping("/add")
    public void addCalificacion(@RequestBody Calificacion calificacion) {
        calificacionService.addCalificacion(alumno.getLegajo(), calificacion);
    }

}
