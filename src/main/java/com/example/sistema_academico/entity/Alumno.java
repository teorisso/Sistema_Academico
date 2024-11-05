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

    @ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER)
    private List<Materia> materias;

    @ManyToOne
    @JoinColumn(name = "comision_id")
    private Comision comision;

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Alumno: Legajo: ").append(legajo)
                .append(", Nombre: ").append(nombre)
                .append(", Apellido: ").append(apellido).append("\n");

        info.append("Materias: ");
        if (materias != null && !materias.isEmpty()) {
            for (Materia materia : materias) {
                info.append("ID: ").append(materia.getId())
                        .append(", Nombre: ").append(materia.getNombre()).append("; ");
            }
        } else {
            info.append("No hay materias asignadas.");
        }

        if (comision != null) {
            info.append("\nComisión: ID: ").append(comision.getId())
                    .append(", Nombre: ").append(comision.getNombre());
        } else {
            info.append("\nNo hay comisión asignada.");
        }

        return info.toString();
    }


}