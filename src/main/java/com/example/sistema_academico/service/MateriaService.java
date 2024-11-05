package com.example.sistema_academico.service;

import com.example.sistema_academico.entity.Materia;
import com.example.sistema_academico.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Transactional
    public void addMateria(Materia materia) {
        try {
            materiaRepository.save(materia);
            System.out.println("Materia agregada con éxito\n" + materia);
        } catch (Exception e) {
            System.out.println("Error al agregar materia\n" + e);
        }
    }

    @Transactional
    public void deleteMateria(Integer id) {
        try {
            materiaRepository.deleteById(id);
            System.out.println("Materia eliminada con éxito");
        } catch (Exception e) {
            System.out.println("Error al eliminar materia\n" + e);
        }
    }

    public Materia getMateria(Integer id) {
        try {
            Materia materia = materiaRepository.findById(id).orElse(null);
            System.out.println("Materia obtenida con éxito\n" + materia);
            return materia;
        } catch (Exception e) {
            System.out.println("Error al obtener materia\n" + e);
            return null;
        }
    }

    public List<Materia> getMaterias() {
        try {
            List<Materia> materias = materiaRepository.findAll();
            System.out.println("Materias obtenidas con éxito\n" + materias);
            return materias;
        } catch (Exception e) {
            System.out.println("Error al obtener materias\n" + e);
            return null;
        }
    }

    @Transactional
    public void updateMateria(Materia materia) {
        try {
            materiaRepository.save(materia);
            System.out.println("Materia actualizada con éxito\n" + materia);
        } catch (Exception e) {
            System.out.println("Error al actualizar materia\n" + e);
        }
    }
}