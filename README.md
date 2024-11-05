
# Proyecto Final Integrador: Sistema de Gestión Académico

Este proyecto, desarrollado en Java, proporciona un sistema de administración de estudiantes y sus calificaciones mediante operaciones CRUD en una base de datos MySQL. Diseñado para funcionar completamente desde la línea de comandos, el sistema permite el registro y la gestión de información académica de manera sencilla y eficiente.

## Tabla de Contenidos

1. [Descripción General](#descripción-general)
2. [Funcionalidades Principales](#funcionalidades-principales)
3. [Requisitos](#requisitos)
4. [Instalación](#instalación)
5. [Uso](#uso)
6. [Ejemplos de Uso](#ejemplos-de-uso)
7. [Autores](#autores)

## Descripción General

El **Sistema de Gestión Académico** facilita la administración de información académica básica. Con este sistema, los usuarios pueden gestionar datos de estudiantes, materias, comisiones y profesores, además de realizar consultas y modificaciones a la base de datos MySQL de manera eficiente.

## Funcionalidades Principales

- **Administración de Estudiantes**: Registro, consulta, actualización y eliminación de estudiantes.
- **Administración de Materias**: Gestión de materias con opciones para agregar, consultar, actualizar y eliminar.
- **Administración de Comisiones**: Control de las comisiones académicas asociadas a los estudiantes y materias.
- **Administración de Profesores**: Registro y gestión de profesores en la base de datos.
- **Operación desde la Línea de Comandos**: Interfaz no gráfica que permite ejecutar todas las operaciones necesarias desde el teclado.

## Requisitos

Para ejecutar este proyecto, asegúrese de contar con los siguientes requisitos:

- Java 17
- MySQL
- IntelliJ IDEA

## Instalación

Siga los pasos a continuación para instalar el sistema en su máquina local:

1. Clone el repositorio en su computadora.
2. Abra el proyecto en IntelliJ IDEA.
3. Importe las dependencias de Maven.
4. Cree la base de datos en MySQL.
5. Configure la conexión a la base de datos en el archivo `application.properties`.
6. Ejecute el proyecto.

## Uso

Para utilizar el sistema:

1. Ingrese al sistema desde la línea de comandos.
2. Seleccione la opción deseada del menú principal.
3. Siga las instrucciones para realizar operaciones de agregación, consulta, actualización o eliminación de registros.

## Ejemplos de Uso

### Administración de Estudiantes

1. **Agregar un estudiante**:
    - Ingresar nombre, apellido, legajo, materia y comisión correspondiente.
2. **Consultar estudiantes**:
    - Realizar búsquedas por legajo, nombre o apellido.
3. **Actualizar información de un estudiante**:
    - Seleccionar estudiante mediante su legajo y actualizar los datos necesarios.
4. **Eliminar un estudiante**:
    - Ingresar el legajo del estudiante para realizar la eliminación.

### Administración de Materias

1. **Agregar una materia**: Introducir nombre y descripción.
2. **Consultar materias**: Buscar por ID, nombre o descripción.
3. **Actualizar una materia**: Seleccionar por ID y actualizar los datos.
4. **Eliminar una materia**: Proveer el ID de la materia para eliminar.

### Administración de Comisiones

1. **Agregar una comisión**: Ingresar el nombre y descripción de la comisión.
2. **Consultar comisiones**: Buscar por ID, nombre o descripción.
3. **Actualizar una comisión**: Seleccionar por ID y actualizar la información.
4. **Eliminar una comisión**: Ingresar el ID para eliminar la comisión.

### Administración de Profesores

1. **Agregar un profesor**: Proporcionar nombre y apellido.
2. **Consultar profesores**: Realizar búsquedas por ID, nombre o apellido.
3. **Actualizar información de un profesor**: Seleccionar por ID y modificar los datos.
4. **Eliminar un profesor**: Proveer el ID del profesor para realizar la eliminación.

## Autores

- [Martina Canteros](https://github.com/MartinaC181)
- [Esteban Cardozo](https://github.com/EstebanCardoz0)
- [Gina Grosso](https://github.com/ginagrosso)
- [Maximo Masdeu](https://github.com/maximomasdeu)
- [Teo Risso](https://github.com/teorisso)
---

Este sistema fue desarrollado como parte de un proyecto final integrador y representa una solución práctica para la gestión de datos académicos básicos.
