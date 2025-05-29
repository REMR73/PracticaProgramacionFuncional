import models.ejercicio2.Empleado;
import models.ejercicio1.Estudiante;
import models.ejercicio2.Producto;
import practica_ejercicios.PracticaEjerciciosGuiados;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Lista de estudiantes
        List<Estudiante> estudiantes = Arrays.asList(
                new Estudiante("Ana", 20, 85.0),
                new Estudiante("Carlos", 19, 92.0),
                new Estudiante("María", 21, 78.0),
                new Estudiante("Pedro", 22, 88.0),
                new Estudiante("Sofía", 20, 95.0),
                new Estudiante("Luis", 23, 76.0)
        );

        System.out.println("=== EJERCICIOS CON LAMBDAS EN JAVA ===\n");

        // EJERCICIO 1: Filtrar estudiantes aprobados (calificación >= 80)
        System.out.println("1. Estudiantes aprobados (calificación >= 80):");


        // EJERCICIO 2: Obtener solo los nombres de todos los estudiantes
        System.out.println("2. Lista de nombres:");

        // EJERCICIO 3: Calcular el promedio de calificaciones
        System.out.println("3. Promedio de calificaciones:");

        System.out.println();

        // EJERCICIO 4: Ordenar estudiantes por calificación (mayor a menor)
        System.out.println("4. Estudiantes ordenados por calificación (mayor a menor):");

        System.out.println();

        // EJERCICIO 5: Encontrar el estudiante más joven
        System.out.println("5. Estudiante más joven:");

        System.out.println();

        // EJERCICIO 6: Crear una lista con el formato "Nombre (Edad años)"
        System.out.println("6. Formato personalizado:");

        System.out.println();

        // EJERCICIO 7: Contar estudiantes mayores de 20 años
        System.out.println("7. Estudiantes mayores de 20 años:");

        System.out.println();


        //practicaGeneral();
    }

    public static void practicaGeneral(){

        // Datos de prueba
        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", "Electrónicos", new BigDecimal("1200.00"), 15, LocalDate.of(2024, 1, 15)),
                new Producto("Mouse", "Electrónicos", new BigDecimal("25.99"), 50, LocalDate.of(2024, 2, 10)),
                new Producto("Mesa", "Muebles", new BigDecimal("300.00"), 8, LocalDate.of(2024, 1, 20)),
                new Producto("Silla", "Muebles", new BigDecimal("150.00"), 12, LocalDate.of(2024, 3, 5)),
                new Producto("Teclado", "Electrónicos", new BigDecimal("75.50"), 30, LocalDate.of(2024, 2, 25)),
                new Producto("Armario", "Muebles", new BigDecimal("800.00"), 3, LocalDate.of(2024, 1, 10))
        );

        List<Empleado> empleados = Arrays.asList(
                new Empleado("Ana García", "IT", new BigDecimal("3500.00"), 28),
                new Empleado("Carlos López", "Ventas", new BigDecimal("2800.00"), 35),
                new Empleado("María Rodríguez", "IT", new BigDecimal("4200.00"), 31),
                new Empleado("Juan Pérez", "Marketing", new BigDecimal("3200.00"), 29),
                new Empleado("Laura Martín", "Ventas", new BigDecimal("2900.00"), 26),
                new Empleado("David Sánchez", "IT", new BigDecimal("3800.00"), 33)
        );

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30);

        PracticaEjerciciosGuiados.EjerciciosPracticos(productos, empleados, numeros);

    }



}
