
package com.example.sistema_academico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer legajo;
    private String nombre;
    private String apellido;

    @ManyToMany(mappedBy = "alumnos")
    private List<Materia> materias;

    @ManyToOne
    @JoinColumn(name = "comision_id") // Define la clave foránea hacia Comision
    private Comision comision;
}
