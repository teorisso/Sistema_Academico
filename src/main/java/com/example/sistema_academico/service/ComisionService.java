package com.example.sistema_academico.service;

import com.example.sistema_academico.entity.Comision;
import com.example.sistema_academico.repository.ComisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComisionService {

    @Autowired
    private ComisionRepository comisionRepository;

    public void addComision(Comision comision) {
        try {
            comisionRepository.save(comision);
            System.out.println("Comisión agregada con éxito");
            System.out.println(comision);
        } catch (Exception e) {
            System.out.println("Error al agregar comisión");
            System.out.println(e);
        }
    }

    public void deleteComision(Integer id) {
        try {
            comisionRepository.deleteById(id);
            System.out.println("Comisión eliminada con éxito");
        } catch (Exception e) {
            System.out.println("Error al eliminar comisión");
            System.out.println(e);
        }
    }

    public Comision getComision(Integer id) {
        try {
            Comision comision = comisionRepository.findById(id).orElse(null);
            System.out.println("Comisión obtenida con éxito");
            System.out.println(comision);
            return comision;
        } catch (Exception e) {
            System.out.println("Error al obtener comisión");
            System.out.println(e);
            return null;
        }
    }

    public List<Comision> getComisiones() {
        try {
            List<Comision> comisiones = comisionRepository.findAll();
            System.out.println("Comisiones obtenidas con éxito");
            System.out.println(comisiones);
            return comisiones;
        } catch (Exception e) {
            System.out.println("Error al obtener comisiones");
            System.out.println(e);
            return null;
        }
    }

    public void updateComision(Comision comision) {
        try {
            comisionRepository.save(comision);
            System.out.println("Comisión actualizada con éxito");
            System.out.println(comision);
        } catch (Exception e) {
            System.out.println("Error al actualizar comisión");
            System.out.println(e);
        }
    }
}
