package models.ejercicio2;

import java.math.BigDecimal;

public class Empleado {
    private String nombre;
    private String departamento;
    private BigDecimal salario;
    private int edad;

    public Empleado(String nombre, String departamento, BigDecimal salario, int edad) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.edad = edad;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDepartamento() { return departamento; }
    public BigDecimal getSalario() { return salario; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f - %d años",
                nombre, departamento, salario, edad);
    }
}
