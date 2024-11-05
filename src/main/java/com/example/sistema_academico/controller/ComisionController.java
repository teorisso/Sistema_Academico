package com.example.sistema_academico.controller;

import com.example.sistema_academico.entity.Comision;
import com.example.sistema_academico.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comision")
public class ComisionController {

    @Autowired
    private ComisionService comisionService;

    @PostMapping("/add")
    public void addComision(@RequestBody Comision comision) {
        comisionService.addComision(comision);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComision(@PathVariable Integer id) {
        comisionService.deleteComision(id);
    }

    @GetMapping("/get")
    public List<Comision> getComisiones() {
        return comisionService.getComisiones();
    }

    @GetMapping("/get/{id}")
    public Comision getComision(@PathVariable Integer id) {
        return comisionService.getComision(id);
    }

    @PutMapping("/update")
    public void updateComision(@RequestBody Comision comision) {
        comisionService.updateComision(comision);
    }
}