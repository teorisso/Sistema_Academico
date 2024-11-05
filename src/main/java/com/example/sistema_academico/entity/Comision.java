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
public class Comision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "comision_profesor",
            joinColumns = @JoinColumn(name = "comision_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id")
    )
    private List<Profesor> profesores;

    @OneToMany(mappedBy = "comision", fetch = FetchType.EAGER)
    private List<Alumno> alumnos;

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Comisión: ID: ").append(id)
                .append(", Nombre: ").append(nombre).append("\n");

        info.append("Profesores: ");
        if (profesores != null && !profesores.isEmpty()) {
            for (Profesor profesor : profesores) {
                info.append("ID: ").append(profesor.getId())
                        .append(", Nombre: ").append(profesor.getNombre()).append("; ");
            }
        } else {
            info.append("No hay profesores asignados.");
        }

        info.append("\nAlumnos: ");
        if (alumnos != null && !alumnos.isEmpty()) {
            for (Alumno alumno : alumnos) {
                info.append("Legajo: ").append(alumno.getLegajo())
                        .append(", Nombre: ").append(alumno.getNombre()).append(" ")
                        .append(alumno.getApellido()).append("; ");
            }
        } else {
            info.append("No hay alumnos asignados.");
        }

        return info.toString();
    }


}