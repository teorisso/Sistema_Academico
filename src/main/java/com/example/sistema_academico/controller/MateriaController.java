package com.example.sistema_academico.controller;

import com.example.sistema_academico.entity.Materia;
import com.example.sistema_academico.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping("/add")
    public void addMateria(@RequestBody Materia materia) {
        materiaService.addMateria(materia);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMateria(@PathVariable Integer id) {
        materiaService.deleteMateria(id);
    }

    @GetMapping("/get")
    public List<Materia> getMaterias() {
        return materiaService.getMaterias();
    }

    @GetMapping("/get/{id}")
    public Materia getMateria(@PathVariable Integer id) {
        return materiaService.getMateria(id);
    }

    @PutMapping("/update")
    public void updateMateria(@RequestBody Materia materia) {
        materiaService.updateMateria(materia);
    }
}