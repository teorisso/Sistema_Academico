package com.example.sistema_academico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int nota1, nota2, nota3;
    private Double calificacion;

    @ManyToOne
    @JoinColumn(name = "alumno_legajo")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    public void calcularCalificacion() {
        this.calificacion = (nota1 + nota2 + nota3) / 3.0;
    }

}
