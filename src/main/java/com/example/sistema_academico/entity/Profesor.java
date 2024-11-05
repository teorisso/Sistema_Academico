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
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;

    @ManyToMany(mappedBy = "profesores")
    private List<Materia> materias;

    @ManyToMany(mappedBy = "profesores")
    private List<Comision> comisiones;

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Profesor: ID: ").append(id)
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

        info.append("\nComisiones: ");
        if (comisiones != null && !comisiones.isEmpty()) {
            for (Comision comision : comisiones) {
                info.append("ID: ").append(comision.getId())
                        .append(", Nombre: ").append(comision.getNombre()).append("; ");
            }
        } else {
            info.append("No hay comisiones asignadas.");
        }

        return info.toString();
    }

}