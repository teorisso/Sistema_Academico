package com.example.sistema_academico.repository;

import com.example.sistema_academico.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {
    List<Calificacion> findByAlumnoLegajo(Integer legajo);
}
