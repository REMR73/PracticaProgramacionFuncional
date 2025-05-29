package models.ejercicio1;

public class Estudiante {
    private String nombre;
    private int edad;
    private double calificacion;

    public Estudiante(String nombre, int edad, double calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificacion = calificacion;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getCalificacion() { return calificacion; }

    // Setter para calificación (para el ejercicio de bonificación)
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }

    @Override
    public String toString() {
        return nombre + " (Edad: " + edad + ", Calificación: " + calificacion + ")";
    }
}
