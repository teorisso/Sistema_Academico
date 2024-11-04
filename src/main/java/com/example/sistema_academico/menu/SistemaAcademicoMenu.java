package com.example.sistema_academico.menu;

import com.example.sistema_academico.entity.Alumno;
import com.example.sistema_academico.entity.Comision;
import com.example.sistema_academico.entity.Materia;
import com.example.sistema_academico.entity.Profesor;
import com.example.sistema_academico.service.AlumnoService;
import com.example.sistema_academico.service.ComisionService;
import com.example.sistema_academico.service.MateriaService;
import com.example.sistema_academico.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SistemaAcademicoMenu implements CommandLineRunner {

    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private ComisionService comisionService;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private ProfesorService profesorService;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Sistema de Gestión Académica ===");
            System.out.println("1. Administrar Alumnos");
            System.out.println("2. Administrar Materias");
            System.out.println("3. Administrar Comisiones");
            System.out.println("4. Administrar Profesores");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> administrarAlumnos();
                case 2 -> administrarMaterias();
                case 3 -> administrarComisiones();
                case 4 -> administrarProfesores();
                case 5 -> {
                    exit = true;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void administrarAlumnos() {
        System.out.println("\n=== Administrar Alumnos ===");
        System.out.println("1. Crear Alumno");
        System.out.println("2. Leer Alumno");
        System.out.println("3. Actualizar Alumno");
        System.out.println("4. Eliminar Alumno");
        System.out.print("Seleccione una opción: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1 -> crearAlumno();
            case 2 -> leerAlumno();
            case 3 -> actualizarAlumno();
            case 4 -> eliminarAlumno();
            default -> System.out.println("Opción inválida.");
        }
    }

    private void crearAlumno() {
        System.out.print("Ingrese nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del alumno: ");
        String apellido = scanner.nextLine();
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumnoService.addAlumno(alumno);
        System.out.println("Alumno creado exitosamente.");
    }

    private void leerAlumno() {
        System.out.print("Ingrese el legajo del alumno: ");
        int legajo = scanner.nextInt();
        Alumno alumno = alumnoService.getAlumno(legajo);
        if (alumno != null) {
            System.out.println("Alumno encontrado: " + alumno);
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    private void actualizarAlumno() {
        System.out.print("Ingrese el legajo del alumno a actualizar: ");
        int legajo = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        Alumno alumno = alumnoService.getAlumno(legajo);
        if (alumno != null) {
            System.out.print("Ingrese el nuevo nombre: ");
            alumno.setNombre(scanner.nextLine());
            System.out.print("Ingrese el nuevo apellido: ");
            alumno.setApellido(scanner.nextLine());
            alumnoService.updateAlumno(alumno);
            System.out.println("Alumno actualizado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    private void eliminarAlumno() {
        System.out.print("Ingrese el legajo del alumno a eliminar: ");
        int legajo = scanner.nextInt();
        alumnoService.deleteAlumno(legajo);
        System.out.println("Alumno eliminado exitosamente.");
    }

    private void administrarMaterias() {
        System.out.println("\n=== Administrar Materias ===");
        System.out.println("1. Crear Materia");
        System.out.println("2. Leer Materia");
        System.out.println("3. Actualizar Materia");
        System.out.println("4. Eliminar Materia");
        System.out.print("Seleccione una opción: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1 -> crearMateria();
            case 2 -> leerMateria();
            case 3 -> actualizarMateria();
            case 4 -> eliminarMateria();
            default -> System.out.println("Opción inválida.");
        }
    }

    private void crearMateria() {
        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción de la materia: ");
        String descripcion = scanner.nextLine();
        Materia materia = new Materia();
        materia.setNombre(nombre);
        materia.setDescripcion(descripcion);
        materiaService.addMateria(materia);
        System.out.println("Materia creada exitosamente.");
    }

    private void leerMateria() {
        System.out.print("Ingrese el ID de la materia: ");
        int id = scanner.nextInt();
        Materia materia = materiaService.getMateria(id);
        if (materia != null) {
            System.out.println("Materia encontrada: " + materia);
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    private void actualizarMateria() {
        System.out.print("Ingrese el ID de la materia a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        Materia materia = materiaService.getMateria(id);
        if (materia != null) {
            System.out.print("Ingrese el nuevo nombre de la materia: ");
            materia.setNombre(scanner.nextLine());
            System.out.print("Ingrese la nueva descripción de la materia: ");
            materia.setDescripcion(scanner.nextLine());
            materiaService.updateMateria(materia);
            System.out.println("Materia actualizada exitosamente.");
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    private void eliminarMateria() {
        System.out.print("Ingrese el ID de la materia a eliminar: ");
        int id = scanner.nextInt();
        materiaService.deleteMateria(id);
        System.out.println("Materia eliminada exitosamente.");
    }

    private void administrarComisiones() {
        System.out.println("\n=== Administrar Comisiones ===");
        System.out.println("1. Crear Comisión");
        System.out.println("2. Leer Comisión");
        System.out.println("3. Actualizar Comisión");
        System.out.println("4. Eliminar Comisión");
        System.out.print("Seleccione una opción: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1 -> crearComision();
            case 2 -> leerComision();
            case 3 -> actualizarComision();
            case 4 -> eliminarComision();
            default -> System.out.println("Opción inválida.");
        }
    }

    private void crearComision() {
        System.out.print("Ingrese el nombre de la comisión: ");
        String nombre = scanner.nextLine();
        Comision comision = new Comision();
        comision.setNombre(nombre);
        comisionService.addComision(comision);
        System.out.println("Comisión creada exitosamente.");
    }

    private void leerComision() {
        System.out.print("Ingrese el ID de la comisión: ");
        int id = scanner.nextInt();
        Comision comision = comisionService.getComision(id);
        if (comision != null) {
            System.out.println("Comisión encontrada: " + comision);
        } else {
            System.out.println("Comisión no encontrada.");
        }
    }

    private void actualizarComision() {
        System.out.print("Ingrese el ID de la comisión a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        Comision comision = comisionService.getComision(id);
        if (comision != null) {
            System.out.print("Ingrese el nuevo nombre de la comisión: ");
            comision.setNombre(scanner.nextLine());
            comisionService.updateComision(comision);
            System.out.println("Comisión actualizada exitosamente.");
        } else {
            System.out.println("Comisión no encontrada.");
        }
    }

    private void eliminarComision() {
        System.out.print("Ingrese el ID de la comisión a eliminar: ");
        int id = scanner.nextInt();
        comisionService.deleteComision(id);
        System.out.println("Comisión eliminada exitosamente.");
    }

    private void administrarProfesores() {
        System.out.println("\n=== Administrar Profesores ===");
        System.out.println("1. Crear Profesor");
        System.out.println("2. Leer Profesor");
        System.out.println("3. Actualizar Profesor");
        System.out.println("4. Eliminar Profesor");
        System.out.print("Seleccione una opción: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1 -> crearProfesor();
            case 2 -> leerProfesor();
            case 3 -> actualizarProfesor();
            case 4 -> eliminarProfesor();
            default -> System.out.println("Opción inválida.");
        }
    }

    private void crearProfesor() {
        System.out.print("Ingrese el nombre del profesor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del profesor: ");
        String apellido = scanner.nextLine();
        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesorService.addProfesor(profesor);
        System.out.println("Profesor creado exitosamente.");
    }

    private void leerProfesor() {
        System.out.print("Ingrese el ID del profesor: ");
        int id = scanner.nextInt();
        Profesor profesor = profesorService.getProfesor(id);
        if (profesor != null) {
            System.out.println("Profesor encontrado: " + profesor);
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private void actualizarProfesor() {
        System.out.print("Ingrese el ID del profesor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        Profesor profesor = profesorService.getProfesor(id);
        if (profesor != null) {
            System.out.print("Ingrese el nuevo nombre del profesor: ");
            profesor.setNombre(scanner.nextLine());
            System.out.print("Ingrese el nuevo apellido del profesor: ");
            profesor.setApellido(scanner.nextLine());
            profesorService.updateProfesor(profesor);
            System.out.println("Profesor actualizado exitosamente.");
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private void eliminarProfesor() {
        System.out.print("Ingrese el ID del profesor a eliminar: ");
        int id = scanner.nextInt();
        profesorService.deleteProfesor(id);
        System.out.println("Profesor eliminado exitosamente.");
    }
}